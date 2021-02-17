package model;

import java.util.ArrayList;

public class Desenvolvedor {

  private final String nome;
  private final ArrayList<Projeto> projetos = new ArrayList<>();

  public Desenvolvedor(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public ArrayList<Projeto> getProjetos() {
    // FIXME: retornar um clone da lista para manter o encapsulamento
    return projetos;
  }

  public boolean podeAlocarNo(Projeto projeto) {
    return ! this.projetos.contains(projeto) && this.projetos.size() < 2;
  }

  public void alocarNo(Projeto projeto) {
    if (this.podeAlocarNo(projeto) && projeto.poderiaAlocarDev(this)) {
      this.projetos.add(projeto);

      // FIXME: Não usar o getDesenvolvedores de Projeto para adicionar-se à lista
      projeto.getDesenvolvedores().add(this);
    }
  }

  @Override
  public String toString() {
    return "DEV_" + this.nome;
  }
}
