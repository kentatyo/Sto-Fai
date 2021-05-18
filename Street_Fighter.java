package enshu1;

import java.util.Random;
import java.util.Scanner;

public class Street_Fighter {
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//開発メモ（追加したい機能）
		//逃げる選択肢

		//簡単な説明
		System.out.println("ストファイ（『ストリートファイター』）");
		System.out.println("---------------------------");
		System.out.println("CPUと対戦する格闘ゲームです。");
		System.out.println("選べるコマンドは、「攻撃」「大攻撃」「回復」「大回復」の4つです。");
		System.out.println("「大攻撃」あるいは「大回復」を選択した場合、次のターンではそのコマンドを選べません。");
		System.out.println("なおCPUは、選べるコマンドに制限はありません。");
		System.out.println("相手のHPを0にしたほうが勝ちです。");
		System.out.println("---------------------------");
		System.out.println("スタート");
		System.out.println("---------------------------");

		//変数設定
		int HP_M = 100;
		int HP_C = 100;
		String HP_MS = "";
		String HP_CS = "";

		int Command_M;
		int Command_C;
		int Command_C_past = 0;
		String Command_M_String;

		int Command_1 = 20;//攻撃
		int Command_2 = 40;//大攻撃
		int Command_3 = 20;//回復
		int Command_4 = 40;//大回復

		boolean flag_1 = false;//大攻撃をしたときのフラグ
		boolean flag_2 = false;//大回復をしたときのフラグ

		System.out.println("---------------------------");
		//以下どちらかのHPが0以下になるまで（つまり両方のHPが0より大きいとき）whileループ
		while (HP_M > 0 && HP_C > 0) {
			//HP表示 
			HP_MS = "";
			HP_CS = "";
			for (int i = 0; i < HP_M / 10; i++) {
				HP_MS += "■";
			}
			for (int i = 0; i < HP_C / 10; i++) {
				HP_CS += "■";
			}
			System.out.println("---------------------------");
			System.out.println("あなたのHP:" + HP_MS);
			System.out.println("ＣＰＵのHP:" + HP_CS);

			System.out.println("---------------------------");
			//自分がコマンドを選ぶ

			//大攻撃が選択肢から外れるとき
			if (flag_1 == true) {
				System.out.println("1:攻撃 3:防御 4:大回復");
				System.out.print("半角数字で入力してください：");
				Scanner scanner1 = new Scanner(System.in);
				Command_M_String = scanner1.nextLine();

				//範囲外の数字を入力されたときの対処
				while (!(Command_M_String.equals("1")) && !(Command_M_String.equals("3"))
						&& !(Command_M_String.equals("4"))) {
					System.out.println("入力できません");
					System.out.print("ちゃんと数字入力してください：");
					//Scanner scanner1 = new Scanner(System.in);
					Command_M_String = scanner1.nextLine();
				}
				Command_M = Integer.parseInt(Command_M_String);
				//フラグを元に戻す
				flag_1 = false;
			}

			//大防御が選択肢から外れるとき
			else if (flag_2 == true) {
				System.out.println("1:攻撃 2:大攻撃 3:回復");
				System.out.print("半角数字で入力してください：");
				Scanner scanner1 = new Scanner(System.in);
				Command_M_String = scanner1.nextLine();

				//範囲外の数字を入力されたときの対処
				while (!(Command_M_String.equals("1")) && !(Command_M_String.equals("2"))
						&& !(Command_M_String.equals("3"))) {
					System.out.println("入力できません");
					System.out.print("ちゃんと数字入力してください：");
					//Scanner scanner1 = new Scanner(System.in);
					Command_M_String = scanner1.nextLine();
				}
				Command_M = Integer.parseInt(Command_M_String);
				//フラグを元に戻す
				flag_2 = false;
			}

			//通常状態
			else {
				System.out.println("1:攻撃 2:大攻撃 3:回復 4:大回復");
				System.out.print("半角数字で入力してください：");
				Scanner scanner1 = new Scanner(System.in);
				Command_M_String = scanner1.nextLine();

				//隠しコマンド
				if (Command_M_String.equals("裏メニュー")) {
					System.out.println("---------------------------");
					System.out.println("---------------------------");
					System.out.println("---------------------------");
					System.out.println("裏メニューへようこそ");
					System.out.println("---------------------------");
					System.out.println("---------------------------");
					ura();

					System.out.println("---------------------------");
					System.out.println("---------------------------");
					System.out.println("---------------------------");
					System.out.println("1:攻撃 2:大攻撃 3:回復 4:大回復");
					System.out.print("半角数字で入力してください：");
					Command_M_String = scanner1.nextLine();
				}

				//範囲外の数字を入力されたときの対処
				while (!(Command_M_String.equals("1")) && !(Command_M_String.equals("2"))
						&& !(Command_M_String.equals("3")) && !(Command_M_String.equals("4"))) {
					System.out.println("入力できません");
					System.out.print("ちゃんと数字入力してください：");
					//Scanner scanner1 = new Scanner(System.in);
					Command_M_String = scanner1.nextLine();
				}
				Command_M = Integer.parseInt(Command_M_String);
			}

			System.out.println("---------------------------");
			System.out.println("あなたは" + Command_M + "を選んだ！！！！");
			System.out.println("");
			//判定
			//自分のHP更新
			switch (Command_M) {
			case 1://攻撃
				HP_C -= Command_1;
				System.out.println("CPUに" + Command_1 + "のダメージ！！！！");
				break;

			case 2://大攻撃
				HP_C -= Command_2;
				System.out.println("CPUに" + Command_2 + "のダメージ！！！！");
				flag_1 = true;
				break;

			case 3://防御
				HP_M += Command_3;
				System.out.println("あなたは" + Command_3 + "回復！！！！");
				break;

			case 4://大防御
				HP_M += Command_4;
				System.out.println("あなたは" + Command_4 + "回復！！！！");
				flag_2 = true;
				break;

			default:
				break;
			}
			System.out.println("");

			//CPUがコマンドを選ぶ（乱数）
			Random random1 = new Random();
			Command_C = random1.nextInt(4) + 1;//乱数の範囲を1から4にするため

			//CPUが2や4を連続で選ばないようにするには
			while (Command_C == 2 || Command_C == 4) {
				if (Command_C == 2 && Command_C_past == 2) {
					Command_C = random1.nextInt(4) + 1;
				} else if (Command_C == 4 && Command_C_past == 4) {
					Command_C = random1.nextInt(4) + 1;
				} else {
					break;
				}
			}
			Command_C_past = Command_C;

			System.out.println("CPUは" + Command_C + "を選んだ！！！！");
			System.out.println("");

			//CPUのHP更新
			switch (Command_C) {
			case 1://攻撃
				HP_M -= Command_1;
				System.out.println("あなたに" + Command_1 + "のダメージ！！！！");
				break;

			case 2://大攻撃
				HP_M -= Command_2;
				System.out.println("あなたに" + Command_2 + "のダメージ！！！！");
				break;

			case 3://防御
				HP_C += Command_3;
				System.out.println("CPUは" + Command_3 + "回復！！！！");
				break;

			case 4://大防御
				HP_C += Command_4;
				System.out.println("CPUは" + Command_4 + "回復！！！！");
				break;

			default:
				break;
			}
		}
		//ここまでwhileループ

		//勝利判定（if文）
		if (HP_M <= 0) {
			System.out.println("あなたの負けです");
		} else {
			System.out.println("CPUの負けです");
		}
	}

	//裏メニュー
	public static void ura() {
		System.out.println("ストファイ（『ストロングゼロ飲んだらファイた（吐いた）』）");
		System.out.println("---------------------------");
		System.out.println("謎のAIに、ストロングゼロを飲ませて、AIが潰れたら負けだよ");
		System.out.println("ルールは数取りゲームと同じだよ");
		System.out.println("---------------------------");

		//現在の数
		int num = 0;
		//最大数
		int max = 0;
		//１回にどれだけ数字をいえるか
		int interval = 0;

		int num_C = 0;
		int num_M = 0;
		int num_past = 0;
		int judge = 0;
		boolean cpu_first = true;
		boolean cpu_senko = true;

		System.out.print("最大何本飲ませますか？：");
		Scanner scanner1 = new Scanner(System.in);
		max = scanner1.nextInt();

		System.out.println("");

		System.out.print("１回のターンで最大何本飲ませますか？：");
		Scanner scanner2 = new Scanner(System.in);
		interval = scanner2.nextInt();

		//必勝の数
		int katu = (max - 1) % (interval + 1);

		//先攻後攻を選ばせる
		System.out.println("");
		System.out.print("先攻後攻どちらにしますか？：");
		String senko_String = "";
		Scanner scanner4 = new Scanner(System.in);
		senko_String = scanner4.nextLine();
		if (senko_String.equals("先攻")) {
			cpu_senko = false;
		} else {
			cpu_senko = true;
		}

		System.out.println();
		System.out.println("---------------------------");

		//以下、無限ループ
		//CPU先攻のとき
		while (cpu_senko == true) {
			System.out.println("---------------------------");
			System.out.println("謎のAIはまだ大丈夫そうです。");
			System.out.println("---------------------------");
			System.out.println();

			//CPUが数を言う
			if (cpu_first == true) {
				//初手かつ先攻
				num_C = katu;
				cpu_first = false;
			} else {
				//2手目以降
				num_C = num_past + interval + 1 - num;
			}
			System.out.println("---------------------------");
			System.out.println("CPUは、謎のAIに、" + num_C + "本渡しました。");

			num += num_C;
			num_past = num;

			System.out.println("謎のAIは、合計" + num + "本飲みました。");
			System.out.println();
			if (num >= max) {
				judge = 1;
				break;
			}

			//自分が入力
			
			System.out.println();
			System.out.print("謎のAIに何本渡しますか？：");
			Scanner scanner3 = new Scanner(System.in);
			num_M = scanner3.nextInt();

			//範囲外の数字を入力されたとき
			while (num_M > interval || num_M <= 0) {
				System.out.println("入力できません");
				System.out.print("範囲内の数字で入力してください：");
				num_M = scanner3.nextInt();
			}

			num += num_M;
			System.out.println("謎のAIは、合計" + num + "本飲みました。");
			System.out.println();
			if (num >= max) {
				judge = 2;
				break;
			}
		}
		//ここまでループ
		//CPU後攻のとき
		int loop = 1;
		while (cpu_senko == false) {
			System.out.println("---------------------------");
			System.out.println("謎のAIはまだ大丈夫そうです。");
			System.out.println("---------------------------");
			System.out.println();

			//自分が入力
			
			System.out.println();
			System.out.print("謎のAIに何本渡しますか？：");
			Scanner scanner3 = new Scanner(System.in);
			num_M = scanner3.nextInt();

			//範囲外の数字を入力されたとき
			while (num_M > interval || num_M <= 0) {
				System.out.println("入力できません");
				System.out.print("範囲内の数字で入力してください：");
				num_M = scanner3.nextInt();
			}

			num += num_M;
			System.out.println("謎のAIは、合計" + num + "本飲みました。");
			System.out.println();
			if (num >= max) {
				judge = 2;
				break;
			}

			//CPUが数を言う
			Random random2 = new Random();
			if (cpu_first == true && num < katu) {
				//初手かつ後攻かつ相手が必勝の数より小さい数を出したとき
				num_C = katu - num;
				cpu_first = false;
			} else if (cpu_first == true && num == katu) {
				//初手かつ後攻かつ相手が必勝の数と同じ数を出したとき
				num_C = random2.nextInt(interval) + 1;//乱数の範囲を1からにするため
				cpu_first = false;
			} else {
				//２手目以降
				if (num == katu + (interval + 1) * loop) {
					System.out.println(katu + (interval + 1) * loop);
					//相手が必勝の数と同じになってしまったら
					num_C = random2.nextInt(interval) + 1;
				} else {
					//相手が必勝の数より小さい数を出したら
					num_C = katu + (interval + 1) * loop - num;
				}
				loop++;
			}
			System.out.println("---------------------------");
			System.out.println("CPUは、謎のAIに、" + num_C + "本渡しました。");

			num += num_C;

			System.out.println("謎のAIは、合計" + num + "本飲みました。");
			System.out.println();
			if (num >= max) {
				judge = 1;
				break;
			}
		}
		//ここまでループ
		System.out.println();
		System.out.println("---------------------------");
		System.out.println("謎のAIは酔いつぶれてしまいました。残念。");
		switch (judge) {
		case 1:
			System.out.println("CPUの負け～～～～");
			break;

		case 2:
			System.out.println("あなたの負け～～～～");
			break;
		}
	}

}
