import java.net.MalformedURLException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TSE extends Remote {
	
	public Candidato registrarCandidato(String numero, String nome, String partido, String cargo) throws RemoteException, MalformedURLException;
	public Eleitor registrarEleitor(String nome) throws RemoteException, MalformedURLException;
	
}
