package chapter3.referenceInjection;

/**
 * Created by Oleksandra_Sliusar on 25-Sep-17.
 */
public class Keeper {
    private Oracle oracle;

    public void setOracle(Oracle oracle) {
        this.oracle = oracle;
    }

    public String toString(){
        return oracle.defineMeaningOfLife();
    }
}
