package model;

import java.util.ArrayList;

public class Projeto {

  private final String nome;
  private ArrayList<Desenvolvedor> desenvolvedores = new ArrayList<>();

  public Projeto(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public ArrayList<Desenvolvedor> getDesenvolvedores() {
    // FIXME: retornar um clone da lista para manter o encapsulamento
    return desenvolvedores;
  }

  public boolean poderiaAlocarDev(Desenvolvedor dev) {
    return ! this.desenvolvedores.contains(dev) && this.desenvolvedores.size() < 5;
  }

  public void alocarDev(Desenvolvedor dev) {
    if (this.poderiaAlocarDev(dev) && dev.podeAlocarNo(this)) {
      this.desenvolvedores.add(dev);
      // FIXME: não usar getProjetos de Desenvolvedor para adicionar-se à lista
      dev.getProjetos().add(this);
    }
  }

  @Override
  public String toString() {
    return "PROJ_" + this.nome;
  }
}
