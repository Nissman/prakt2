package com.cheskii.lesson4;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.assertj.core.api.Assertions.assertThat;

public class TriangleTest {

    private static final Logger logger
            = LoggerFactory.getLogger(TriangleTest.class);

    @ParameterizedTest
    @DisplayName("Проверка существования треугольников")
    @CsvSource({"3,0,3,false","3,3,3,true","3,1,3,true"})
    void checkExistTtiangle(int a,int b,int c, boolean results){
        boolean exist = AreaOfTheTriangle.ExistenceTriangle(a,b,c);
        logger.info("info log: exist =" + exist);
        assertThat(exist).isEqualTo(results);
    }

    @ParameterizedTest
    @DisplayName("Вычисление площади при условии, что треугольник сущеуствует")
    @CsvSource({"3,0,3,0","3,3,3,3.897114317029974","3,1,3,1.479019945774904"})
    void chekAreaOfTriangle(int a,int b,int c, double result){
        Assumptions.assumeTrue(AreaOfTheTriangle.ExistenceTriangle(a,b,c));
        double S = AreaOfTheTriangle.OnThreeSides(a,b,c);
        logger.info("info log: S =" + S);
        assertThat(S).isEqualTo(result);
        System.out.println();
    }
}
