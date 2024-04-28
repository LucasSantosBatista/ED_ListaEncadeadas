package model;

public interface ILista<T> {
	public void addFirst(T t);

	public void addLast(T t) throws Exception;

	public void add(T t, int posicao) throws Exception;

	public void removeFirst() throws Exception;

	public void removeLast() throws Exception;

	public void remove(int posicao) throws Exception;

	public boolean isEmpty();

	public No<T> getNo(int posicao) throws Exception;

	public T get(int posicao) throws Exception;

	public int size();
}
