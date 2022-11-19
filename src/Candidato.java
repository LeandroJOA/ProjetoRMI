import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Candidato extends Remote {
	
	public int obterVotos() throws RemoteException;
	public String obterNumero() throws RemoteException;
	public String obterNome() throws RemoteException;
	public String obterPartido() throws RemoteException;
	public void creditarVoto() throws RemoteException;
	
}
