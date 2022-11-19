import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TSEImpl extends UnicastRemoteObject implements TSE {

	private int numeroEleitor = 1;
	
	public TSEImpl() throws RemoteException {
		super();
	}

	public Candidato registrarCandidato(String numero, String nome, String partido, String cargo) throws RemoteException, MalformedURLException {
		Candidato candidato = new CandidatoImpl(numero, nome, partido, cargo);
		Naming.rebind(cargo + numero, (Remote) candidato);
		System.out.println("Candidato registrado com sucesso!");
		System.out.println("Numero: " + candidato.obterNumero());
		System.out.println("Nome: " + candidato.obterNome());
		System.out.println("Partido: " + candidato.obterPartido());
		
		return candidato;
	}

	public Eleitor registrarEleitor(String nome) throws RemoteException, MalformedURLException {
		Eleitor eleitor = new EleitorImpl(nome, numeroEleitor);
		Naming.rebind(Integer.toString(numeroEleitor), (Remote) eleitor);
		System.out.println("Eleitor registrado com sucesso!");
		System.out.println("Nome: " + eleitor.obterNome());
		System.out.println("Numero: " + eleitor.obterTitulo());
		numeroEleitor++;
		
		return eleitor;
	}
	
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		TSE tse = new TSEImpl();
		Naming.rebind("TSE", tse);
		
		System.out.println("TSE registrado com sucesso!");
	}

}
