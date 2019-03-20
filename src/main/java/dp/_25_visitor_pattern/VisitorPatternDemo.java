package dp._25_visitor_pattern;

public class VisitorPatternDemo {
   public static void main(String[] args) {
 
      ComputerPart computer = new Computer();
      computer.accept(new ComputerPartDisplayVisitor());

      computer.accept(new ComputerPartCloseVisitor());
   }
}