package kodluyoruz.librarysystem.exception;

public class IdNotFoundException  extends  RuntimeException{
    public IdNotFoundException(Integer id){
        super(String.format("THERE IS NO SUCH ID IN OUR SYSTEM!!!!!!!"));
    }

}
