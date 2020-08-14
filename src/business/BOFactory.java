package business;

import business.custom.impl.BookBOImpl;
import business.custom.impl.IssueBOImpl;
import business.custom.impl.MemberBOImpl;
import business.custom.impl.ReturnBOImpl;

public class BOFactory {

    private static BOFactory boFactory;

    public BOFactory() {
    }

    public static BOFactory getInstance(){
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public <T extends SuperBO> T getBO(BOType boType) {
        switch (boType){
            case Book:
                return (T) new BookBOImpl();
            case Issue:
                return (T) new IssueBOImpl();
            case Member:
                return (T) new MemberBOImpl();
            case Return:
                return (T) new ReturnBOImpl();
            default:
                return null;
        }
    }
}
