package chapter12practices;

//Using the documentation for java.util.regex.Pattern as a resource,
//replace all the vowels in Splitting.knights with underscores.
import java.util.*;

public class Replacing9 {
	public static String knights =
		"Then, when you have found the shrubbery, you must " +
		"cut down the mightiest tree in the forest... " +
		"with... a herring!";
	public static void main(String[] args) {
		System.out.println(knights);
		System.out.println(knights.replaceAll("[aeiouAEIOU]", "_"));
	}
}
/*Output:

Then, when you have found the shrubbery, you must cut down the mightiest tree in the forest... with... a herring!
Th_n, wh_n y__ h_v_ f__nd th_ shr_bb_ry, y__ m_st c_t d_wn th_ m_ght__st tr__ _n th_ f_r_st... w_th... _ h_rr_ng!

 */
