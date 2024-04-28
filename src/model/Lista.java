package model;

public class Lista<T> implements ILista<T> {

	private No<T> primeiro;

	public Lista() {
		primeiro = null;
	}

	public boolean isEmpty() {
		if (primeiro == null) {
			return true;
		} else {
			return false;
		}
	}

	public int size() {
		int cont = 0;
		if (!isEmpty()) {
			No<T> aux = primeiro;
			while (aux != null) {
				cont++;
				aux = aux.proximo;
			}
		}
		return cont;
	}

	public No<T> getNo(int posicao) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista vazia!");
		}
		int tamanho = size();
		if (posicao < 0 || posicao > tamanho - 1) {
			throw new Exception("Posição Inválida!");
		}
		No<T> aux = primeiro;
		int cont = 0;
		while (cont < posicao) {
			aux = aux.proximo;
			cont++;
		}
		return aux;
	}

	public void addFirst(T valor) {
		No<T> elemento = new No<>();
		elemento.dado = valor;
		elemento.proximo = primeiro;
		primeiro = elemento;
	}

	public void addLast(T valor) throws Exception {
		int tamanho = size();
		if (isEmpty()) {
			throw new Exception("Lista vazia!");
		}
		No<T> elemento = new No<>();
		elemento.dado = valor;
		elemento.proximo = null;
		No<T> ultimo = getNo(tamanho - 1);
		ultimo.proximo = elemento;
	}

	public void add(T valor, int posicao) throws Exception {
		int tamanho = size();
		if (posicao < 0 || posicao > tamanho) {
			throw new Exception("Posição Inválida!");
		}

		if (posicao == 0) {
			addFirst(valor);
		} else if (posicao == tamanho) {
			addLast(valor);
		} else {
			No<T> elemento = new No<>();
			elemento.dado = valor;
			No<T> anterior = getNo(posicao - 1);
			elemento.proximo = anterior.proximo;
			anterior.proximo = elemento;
		}

	}

	public void removeFirst() throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista vazia!");
		}
		primeiro = primeiro.proximo;
	}

	public void removeLast() throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista vazia!");
		}
		int tamanho = size();
		if (tamanho == 1) {
			removeFirst();
		} else {
			No<T> penultimo = getNo(tamanho - 2);
			penultimo = penultimo.proximo;
		}
	}

	public void remove(int posicao) throws Exception {
		int tamanho = size();
		if (posicao < 0 || posicao > tamanho - 1) {
			throw new Exception("Posição Inválida!");
		}
		if (isEmpty()) {
			throw new Exception("Lista vazia!");
		}

		if (posicao == 0) {
			removeFirst();
		} else if (posicao == tamanho - 1) {
			removeLast();
		} else {
			No<T> anterior = getNo(posicao - 1);
			No<T> atual = getNo(posicao);
			anterior.proximo = atual.proximo;
		}
	}

	public T get(int posicao) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista vazia!");
		}
		
		int tamanho = size();
		if (posicao < 0 || posicao > tamanho - 1){
			throw new Exception("Posição Inválida!");
		}
		
		int cont = 0;
		No<T> aux = primeiro;
		while (cont < posicao) {
			aux = aux.proximo;
			cont++;
		}
		return aux.dado;
	}

}
