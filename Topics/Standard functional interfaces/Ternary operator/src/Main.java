import java.util.Objects;
import java.util.function.*;

class Operator {

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        return t -> {
            if (condition.test(t)) {
                return ifTrue.apply(t);
            } else {
                return ifFalse.apply(t);
            }
        };

    }
}

class Tester {
    public static void main(String[] args) {
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = Operator.ternaryOperator(condition, ifTrue, ifFalse);

        String str = "Java";
        int len = safeStringLength.apply(str);
        System.out.println(len);
    }
}