package br.com.banco;

public class ContaBancariaIterator implements Iterator<ContaBancaria> {
    private ArrayList<ContaBancaria> accounts;
    private int position = 0;

    public ContaBancariaIterator(ArrayList<ContaBancaria> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean hasNext() {
        return position < accounts.size();
    }

    @Override
    public ContaBancaria next() {
        if (hasNext()) {
            ContaBancaria account = accounts.get(position);
            position++;
            return account;
        }
        throw new NoSuchElementException("No hay más elementos en la lista.");
    }
}