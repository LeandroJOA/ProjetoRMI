import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class UrnaImpl {

	private TSE tse;
	private BufferedReader teclado;

	public UrnaImpl() throws MalformedURLException, RemoteException, NotBoundException {
		tse = (TSE) Naming.lookup("//localhost/TSE");
		teclado = new BufferedReader(new InputStreamReader(System.in));
	}

	public static void main(String[] args) throws NotBoundException, IOException {
		UrnaImpl urnaImpl = new UrnaImpl();

		String opcao;

		while (true) {
			System.out.println("Escolha uma opção:");
			System.out.println("1) Cadastrar candidato");
			System.out.println("2) Cadastrar eleitor");
			System.out.println("3) Votar");
			System.out.println("4) Resultado");

			opcao = urnaImpl.teclado.readLine();

			switch (opcao) {
				case "1":
					urnaImpl.registrarCandidato();
					break;
				case "2":
					urnaImpl.registrarEleitor();
					break;
				case "3":
					urnaImpl.votar();
					break;
				default:
					System.out.println("ERROR opção invalida!");
			}
		}
	}

	public void registrarCandidato() throws IOException {
		System.out.println("Informe o numero do candidato: ");
		String numeroCandidato = teclado.readLine();

		System.out.println("Informe o nome do candidato: ");
		String nomeCandidato = teclado.readLine();

		System.out.println("Informe o partido do candidato: ");
		String partidoCandidato = teclado.readLine();

		System.out.println("Informe o cargo do candidato: ");
		String cargoCandidato = teclado.readLine();

		Candidato candidato = tse.registrarCandidato(numeroCandidato, nomeCandidato, partidoCandidato, cargoCandidato);
	}

	public void registrarEleitor() throws IOException {

		System.out.println("Informe o nome do eleitor: ");
		String nomeEleitor = teclado.readLine();

		Eleitor eleitor = tse.registrarEleitor(nomeEleitor);
	}

	public void votar() throws IOException, NotBoundException {
		System.out.println("Informe o numero do eleitor: ");
		String numeroEleitor = teclado.readLine();

		Eleitor eleitor = (Eleitor) Naming.lookup("//localhost/" + numeroEleitor);

		System.out.println("Informe o numero para senador: ");
		String numeroSenador = teclado.readLine();
		Candidato senador = (Candidato) Naming.lookup("//localhost/S" + numeroSenador);
		senador.creditarVoto();
		System.out.println("Voto para o candidato " + senador.obterNome() + " registrado com sucesso!");

		System.out.println("Informe o numero para governador: ");
		String numeroGovernador = teclado.readLine();
		Candidato governador = (Candidato) Naming.lookup("//localhost/G" + numeroGovernador);
		governador.creditarVoto();
		System.out.println("Voto para o candidato " + governador.obterNome() + " registrado com sucesso!");

		System.out.println("Informe o numero para presidente: ");
		String numeroPresidente = teclado.readLine();
		Candidato presidente = (Candidato) Naming.lookup("//localhost/P" + numeroPresidente);
		presidente.creditarVoto();
		System.out.println("Voto para o candidato " + presidente.obterNome() + " registrado com sucesso!");
	}
}
