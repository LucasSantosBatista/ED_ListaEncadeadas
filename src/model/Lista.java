package model;

public class Lista<T> implements ILista<T> {

	private No<T> primeiro;

	public Lista() {
		primeiro = null;
	}

	public void addFirst(T t) {
		No<T> elemento = new No<>();
		elemento.dado = t;
		elemento.proximo = primeiro;
		primeiro = elemento;
	}

	public void addLast(T t) throws Exception {
		int tamanho = size();
		if (isEmpty()) {
			throw new Exception("Lista vazia!");
		}
		No<T> elemento = new No<>();
		elemento.dado = t;
		elemento.proximo = null;
		No<T> ultimo = get(tamanho - 1);
		ultimo.proximo = elemento;
	}

	public void add(T t, int posicao) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista vazia!");
		}
		int tamanho = size();
		if (posicao < 0 || posicao > tamanho) {
			throw new Exception("Posição Inválida!");
		}

		if (posicao == 0) {
			addFirst(t);
		} else if (posicao == tamanho) {
			addLast(t);
		} else {
			No<T> elemento = new No<>();
			elemento.dado = t;
			No<T> anterior = get(posicao - 1);
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
			No<T> penultimo = get(tamanho - 2);
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
			No<T> anterior = get(posicao - 1);
			No<T> atual = get(posicao);
			anterior.proximo = atual.proximo;
		}
	}

	public boolean isEmpty() {
		if (primeiro == null) {
			return true;
		} else {
			return false;
		}
	}

	public No<T> get(int posicao) throws Exception {
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
			cont++;
			aux = aux.proximo;
		}
		return aux;
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

}
