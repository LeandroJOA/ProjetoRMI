import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class EleitorImpl extends UnicastRemoteObject implements Eleitor {
	
	private String nome;
	private int numero;
	
	public EleitorImpl(String nome, int numero) throws RemoteException {
		super();
		this.nome = nome;
		this.numero = numero;
	}
	
	public String obterNome() throws RemoteException {
		return nome;
	}

	public int obterTitulo() throws RemoteException {
		return numero;
	}

}
