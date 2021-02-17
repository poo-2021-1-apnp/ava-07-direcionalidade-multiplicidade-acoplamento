import model.*;

class App {
  public static void main(String[] args) {
    System.out.println("Olá mundo!");
    Projeto p1 = new Projeto("p1");
    Projeto p2 = new Projeto("p2");
    Projeto p3 = new Projeto("p3");
    Desenvolvedor d1 = new Desenvolvedor("d1");
    Desenvolvedor d2 = new Desenvolvedor("d2");
    Desenvolvedor d3 = new Desenvolvedor("d3");
    Desenvolvedor d4 = new Desenvolvedor("d4");
    Desenvolvedor d5 = new Desenvolvedor("d5");
    Desenvolvedor d6 = new Desenvolvedor("d6");
    Desenvolvedor d7 = new Desenvolvedor("d7");

    p1.alocarDev(d1);
    System.out.println(p1.getDesenvolvedores());
    System.out.println(d1.getProjetos().size() == 1);
    System.out.println(d1.getProjetos());
    p2.alocarDev(d1);
    System.out.println(d1.getProjetos().size() == 2);
    System.out.println(d1.getProjetos());
    p3.alocarDev(d1);
    System.out.println(d1.getProjetos().size() == 2);
    System.out.println(d1.getProjetos());

    // FIXME: é possível adicionar projetos ao dev e devs ao projeto
    // enquanto os get's retornarem a lista real em vez de um clone.
    d1.getProjetos().add(p2); // não deveria causar efeito
    d1.getProjetos().add(p3); // não deveria causar efeito
    // mas causa:
    System.out.println(d1.getProjetos().size() == 2); // FALSE, deveria ser TRUE
    System.out.println(d1.getProjetos());

    // FIXME: não expor os métodos contratuais entre dev e projeto
    // o método podeAlocarNo deveria ser inacessível para o App.java
    System.out.println(d1.podeAlocarNo(p4));
  }
}
