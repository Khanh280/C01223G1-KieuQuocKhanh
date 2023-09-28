package resentation.inheritance;

public interface CInterface extends AInterface,BInterface{

    @Override
    default void hanhdong() {
//        BInterface.super.hanhdong();
//        AInterface.super.hanhdong();
    }
}
