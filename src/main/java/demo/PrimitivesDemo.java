package demo;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public strictfp class PrimitivesDemo {
    @NotNull
    private String state;

    public strictfp static void main(String[] args) {
        //region Целые со знаком
        byte b = 1_00; //1 byte, Byte.MAX_VALUE
        short s = 010; //2 byte
        int i = 0x10; //4 bytes
        long l = 10000000000000L; //8 byte
        //endregion

        //region С плавающей точкой
        float f = 0.0000000000000000000000000000000000000001f; //16 byte, IEEE 754?
        double d = -2e-5d; //32 byte
        //endregion

        //region Символы
        char c = '\t'; //\u1234
        System.out.println(c);
        //endregion

        //region Логический
        boolean boo = true | false;
        //endregion
        //region Casting
        int ii=1000;
        byte bb = (byte) ii;
        System.out.println(bb);
        //endregion
        //region Арифметические
        int vi=5;
        double vd=2;
        System.out.println(vi/vd);//оператор будет возвра0ать ответ в типе старшего типа одного из
        //операндов
        System.out.println(1+2+"3"+3+5);//3345
        //endregion

        //region Shifts
        int Shi1=5;
        System.out.println(Shi1>>>1);//разобраться
        //endregion

        //regioт Тернарный
        System.out.println(true?"1":"2");
        //endregion


        //region Проблемы
        //regioт Type Overflow
        byte count = 0;
        for (int j = 0; j < 129; j++) {
            count ++;
        }
        System.out.println(count);
        //endregion
        //region Потеря точности
        System.out.println(.1+.2);
        //решение: создавать новый класс дробных чисел в
        //котором будет информация о знаменателе и числителе
        //с иррациональными числами все ранво будет потеря точности

        //region Деление на 0
        //Static Analizers:PMD,CheckStyle,FindBugs ||
        //запускается на этапе сборки
        System.out.println(1/0);//ArifmeticExeption / by Zero
        System.out.println(1/0.);//Double.POSITIVE_INFINITY
        System.out.println(-1/0.);//Double.NEGATIVE_INFINITY
        System.out.println(0/0.);//Double.NaN
        //endregion
        //endregion
        //endregion
        System.out.println(1/0.);
        System.out.println(.1 + .2); //+ type overflow

        //region Operators
        //region Casting
        int ii = 1000;
        byte bb = (byte) ii;
        System.out.println(bb);
        //endregion

        //region Арифметические
        System.out.println(1 / 1);
        int counter = 0; counter++;
        counter *= 2;
        System.out.println( 10 % 2 );
        //endregion

        //region Bitwise
        byte i1 = 1, i2 = 4;
        //i1 = 001, i2 = 0100
        System.out.println(i2 >>> 1);
        //endregion

        //region Logical
        boolean b1 = false, b2 = true;
        System.out.println(isB1() && isB2());//and, or, not
        System.out.println(!b1);
        System.out.println(1 == 2);  // > = = =

        Cat cat1 = new Cat(1);
        Cat cat2 = new Cat(1);
        cat1.equals(cat2); // = = =

        System.out.println( isB1() ? 1 : isB2() ? "1" : 2);

        cat1 = null;
        if (cat1 != null) {
            System.out.println(cat1.getId());
        }
        Optional<Cat> maybeCat = Optional.empty();
//        fopen("cdf") or die()
        //endregion
        //endregion

        //region Проблемы
        //region Type Overflow
        byte count = 0;
        for (int j = 0; j < 129; j++) {
            count++;
        }
        System.out.println(count);
        //endregion

        //region Потеря точности
        System.out.println(.1 + .2);
        //endregion

        //region Zero
        //Static Analyzers: PMD, CheckStyle, FindBugs
        System.out.println(1/0); //ArEx: / by zero
        System.out.println(2/0.);
        //endregion
        //endregion
    }

    private static boolean isB2() {
        return false;
    }

    private static boolean isB1() {
        return false;
    }
}

class Cat extends Object {
    private int id;

    public Cat(int id) {
        this.id = id;
    }

    public int getId() {
        return id;

    }
}