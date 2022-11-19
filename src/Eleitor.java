import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Eleitor extends Remote {
	
	public String obterNome() throws RemoteException;
	public int obterTitulo() throws RemoteException;
	
}
