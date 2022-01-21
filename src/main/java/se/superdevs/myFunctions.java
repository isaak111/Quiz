package se.superdevs;

@FunctionalInterface
interface stringReturnString{
    String check(String string);
}

@FunctionalInterface
interface MyFuncIgen <T, R> {
    R apply(T t);
}
