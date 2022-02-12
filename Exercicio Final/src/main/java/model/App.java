package model;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DaoIPVA maca = new DaoIPVA();
		System.out.println(maca.exibirIpva());
		
		IPVA laranja = new IPVA(2026);
		maca.inserirIpva(laranja);
		System.out.println(maca.exibirIpva());
	}
}
//		
////		User laranja1 = new User("Will", "Japão", "melao@rd.com.br");
////		maca.insert(laranja1);
////		System.out.println(maca.selectAll());
////		
////		maca.delete(2);
////		System.out.println(maca.selectAll());
////		
////		User laranja2 = new User("Muryllo", "Malásia", "uva@rd.com.br");
////		maca.insert(laranja2);
////		System.out.println(maca.selectAll());
////		
////		maca.delete(2);
////		System.out.println(maca.selectAll());
////		
////		laranja.setModelo("monza");;
////		maca.atualizar(laranja);
////		System.out.println(maca.exibir());
//////		
////		User novo = maca.selectById(3);
////		System.out.println(novo);
////		
////		User novo1 = maca.selectById(10);
////		System.out.println(novo1);
//	}
//
//}
