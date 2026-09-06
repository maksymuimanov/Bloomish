package io.bloomish.api.util;

import io.bloomish.api.ApiMod;
import net.neoforged.fml.ModList;
import net.neoforged.neoforgespi.language.IModFileInfo;
import net.neoforged.neoforgespi.language.IModInfo;
import net.neoforged.neoforgespi.language.ModFileScanData;
import net.neoforged.neoforgespi.locating.IModFile;
import org.objectweb.asm.Type;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ReflectionUtils {
    private static final Set<Class<? extends Annotation>> IGNORED_ANNOTATIONS = Set.of(Retention.class, Target.class, Documented.class);

    private ReflectionUtils() {
    }

    public static boolean isConstructorDependency(Constructor<?> constructor, Constructor<?> dependency) {
        return isParameterTypePresent(constructor, dependency.getDeclaringClass());
    }

    public static boolean isParameterTypePresent(Constructor<?> constructor, Class<?> clazz) {
        return Arrays.asList(constructor.getParameterTypes()).contains(clazz);
    }

    public static <T> Stream<T> staticFieldStream(Class<?> clazz, Predicate<Field> filteringPredicate, Function<Object, T> mapper) {
        return Arrays.stream(clazz.getDeclaredFields())
                .filter(filteringPredicate)
                .map(ReflectionUtils::extractStaticFieldValue)
                .map(mapper);
    }

    public static boolean isAnnotationPresentDeep(Class<?> clazz, Class<? extends Annotation> target) {
        for (Annotation annotation : clazz.getDeclaredAnnotations()) {
            Class<? extends Annotation> annotationType = annotation.annotationType();
            boolean isPresent = annotationType.equals(target) || isAnnotationPresentDeep(annotationType, target);
            if (isPresent) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public static <A extends Annotation> Optional<A> findDeepAnnotation(Class<?> clazz, Class<A> target) {
        for (Annotation annotation : clazz.getDeclaredAnnotations()) {
            Class<? extends Annotation> annotationType = annotation.annotationType();
            if (annotationType.equals(target)) {
                return Optional.of((A) annotation);
            }
            Optional<A> result = findDeepAnnotation(annotationType, target);
            if (result.isPresent()) {
                return result;
            }
        }
        return Optional.empty();
    }

    public static Set<Annotation> extractDeepAnnotations(Annotation[] annotations) {
        return extractDeepAnnotations(annotations, IGNORED_ANNOTATIONS);
    }

    public static Set<Annotation> extractDeepAnnotations(Annotation[] annotations, Set<Class<? extends Annotation>> ignoredAnnotations) {
        Set<Annotation> extractedAnnotations = new HashSet<>();
        for (Annotation annotation : annotations) {
            Class<? extends Annotation> annotationType = annotation.annotationType();
            if (!ignoredAnnotations.contains(annotationType)) {
                extractedAnnotations.add(annotation);
                Set<Annotation> childAnnotations = extractDeepAnnotations(annotationType.getDeclaredAnnotations(), ignoredAnnotations);
                extractedAnnotations.addAll(childAnnotations);
            }
        }
        return extractedAnnotations;
    }

    public static <T> T createObject(Class<? extends T> clazz) {
        try {
            return createObject(clazz.getConstructor());
        } catch (NoSuchMethodException e) {
            throw new ReflectionException("Failed to create object for class with default constructor " + clazz.getName(), e);
        }
    }

    public static <T> T createObject(Constructor<? extends T> constructor, Object... params) {
        try {
            constructor.setAccessible(true);
            return constructor.newInstance(params);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new ReflectionException("Failed to create object for class " + constructor.getDeclaringClass().getName() + " with parameter count " + constructor.getParameterCount(), e);
        }
    }

    public static <T> T extractStaticFieldValue(Field field) {
        return extractFieldValue(field, null);
    }

    @SuppressWarnings("unchecked")
    public static <T> T extractFieldValue(Field field, Object object) {
        try {
            field.setAccessible(true);
            return (T) field.get(object);
        } catch (IllegalAccessException e) {
            throw new ReflectionException("Failed to get field value for field " + field.getName(), e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T invokeStaticMethod(Method method, Object... params) {
        try {
            method.setAccessible(true);
            return (T) method.invoke(null, params);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new ReflectionException("Failed to invoke method for method " + method.getName(), e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T invokeMethod(Method method, Object object, Object... params) {
        try {
            method.setAccessible(true);
            return (T) method.invoke(object, params);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new ReflectionException("Failed to invoke method for method " + method.getName(), e);
        }
    }

    public static Class<?> forType(Type type, Class<?> clazz) {
        return forName(type.getClassName(), clazz);
    }

    public static Class<?> forName(String name, Class<?> clazz) {
        try {
            return Class.forName(name, false, clazz.getClassLoader());
        } catch (ClassNotFoundException e) {
            throw new ReflectionException("Failed to load class for name " + name, e);
        }
    }

    public static Set<Class<?>> getApiDependentsClasses() {
        return ModList.get().getMods()
                .stream()
                .filter(iModInfo -> iModInfo.getDependencies()
                        .stream()
                        .anyMatch(modVersion -> modVersion.getModId().equals(ApiMod.MOD_ID)))
                .map(IModInfo::getOwningFile)
                .map(IModFileInfo::getFile)
                .map(IModFile::getScanResult)
                .map(ModFileScanData::getClasses)
                .flatMap(Collection::stream)
                .map(ModFileScanData.ClassData::clazz)
                .map(clazz -> forType(clazz, ApiMod.class))
                .collect(Collectors.toSet());
    }

    public static Set<Class<?>> getApiClasses() {
        return ModList.get()
                .getModFileById(ApiMod.MOD_ID)
                .getFile()
                .getScanResult()
                .getClasses()
                .stream()
                .map(ModFileScanData.ClassData::clazz)
                .map(clazz -> forType(clazz, ApiMod.class))
                .collect(Collectors.toSet());
    }
}
