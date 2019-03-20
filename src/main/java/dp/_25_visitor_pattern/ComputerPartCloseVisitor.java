package dp._25_visitor_pattern;

public class ComputerPartCloseVisitor implements ComputerPartVisitor {
 
   @Override
   public void visit(Computer computer) {
      System.out.println("closing Computer.");
   }
 
   @Override
   public void visit(Mouse mouse) {
      System.out.println("closing Mouse.");
   }
 
   @Override
   public void visit(Keyboard keyboard) {
      System.out.println("closing Keyboard.");
   }
 
   @Override
   public void visit(Monitor monitor) {
      System.out.println("closing Monitor.");
   }
}