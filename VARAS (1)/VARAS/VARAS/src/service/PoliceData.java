package service;

import java.util.*;
import java.io.*;

public class PoliceData {
    private static Map<String, String> policeStationMap = new HashMap<>();
    private static List<String> policeLogs = new ArrayList<>();
    private static final String DATA_FILE = "police_stations.txt";
    private static final String LOG_FILE = "police_log.txt";
    
    static {
        // ==================== CHENNAI DISTRICT ====================
        policeStationMap.put("chennai_anna nagar", "Anna Nagar Police Station");
        policeStationMap.put("chennai_t.nagar", "T.Nagar Police Station");
        policeStationMap.put("chennai_mylapore", "Mylapore Police Station");
        policeStationMap.put("chennai_guindy", "Guindy Police Station");
        policeStationMap.put("chennai_adyar", "Adyar Police Station");
        policeStationMap.put("chennai_ambattur", "Ambattur Police Station");
        policeStationMap.put("chennai_perambur", "Perambur Police Station");
        policeStationMap.put("chennai_thiruvottiyur", "Thiruvottiyur Police Station");
        policeStationMap.put("chennai_velachery", "Velachery Police Station");
        policeStationMap.put("chennai_royapuram", "Royapuram Police Station");
        policeStationMap.put("chennai_tharamani", "Tharamani Police Station");
        policeStationMap.put("chennai_purasawalkam", "Purasawalkam Police Station");
        policeStationMap.put("chennai_tambaram", "Tambaram Police Station");
        policeStationMap.put("chennai_kodambakkam", "Kodambakkam Police Station");
        policeStationMap.put("chennai_vadapalani", "Vadapalani Police Station");
        policeStationMap.put("chennai_washermanpet", "Washermanpet Police Station");
        policeStationMap.put("chennai_tondiarpet", "Tondiarpet Police Station");
        policeStationMap.put("chennai_kilpauk", "Kilpauk Police Station");
        policeStationMap.put("chennai_egmore", "Egmore Police Station");
        policeStationMap.put("chennai_triplicane", "Triplicane Police Station");

        // ==================== ARIYALUR DISTRICT ====================
        policeStationMap.put("ariyalur_ariyalur", "Ariyalur Police Station");
        policeStationMap.put("ariyalur_jayankondam", "Jayankondam Police Station");
        policeStationMap.put("ariyalur_udukkottai", "Udukkottai Police Station");
        policeStationMap.put("ariyalur_sendurai", "Sendurai Police Station");
        policeStationMap.put("ariyalur_andimadam", "Andimadam Police Station");
        policeStationMap.put("ariyalur_thathanur", "Thathanur Police Station");
        policeStationMap.put("ariyalur_veeraganur", "Veeraganur Police Station");
        policeStationMap.put("ariyalur_keelapaluvur", "Keelapaluvur Police Station");
        policeStationMap.put("ariyalur_thirumanur", "Thirumanur Police Station");
        policeStationMap.put("ariyalur_kovilur", "Kovilur Police Station");
        policeStationMap.put("ariyalur_elakurichi", "Elakurichi Police Station");
        policeStationMap.put("ariyalur_meensurutti", "Meensurutti Police Station");
        policeStationMap.put("ariyalur_rayampuram", "Rayampuram Police Station");
        policeStationMap.put("ariyalur_thaluthalai", "Thaluthalai Police Station");
        policeStationMap.put("ariyalur_kovandakurichi", "Kovandakurichi Police Station");

        // ==================== CHENGALPATTU DISTRICT ====================
        policeStationMap.put("chengalpattu_chengalpattu", "Chengalpattu Police Station");
        policeStationMap.put("chengalpattu_maduravoyal", "Maduravoyal Police Station");
        policeStationMap.put("chengalpattu_thiruporur", "Thiruporur Police Station");
        policeStationMap.put("chengalpattu_chellambakkam", "Chellambakkam Police Station");
        policeStationMap.put("chengalpattu_vandalur", "Vandalur Police Station");
        policeStationMap.put("chengalpattu_uthiramerur", "Uthiramerur Police Station");
        policeStationMap.put("chengalpattu_madurantakam", "Madurantakam Police Station");
        policeStationMap.put("chengalpattu_kovalam", "Kovalam Police Station");
        policeStationMap.put("chengalpattu_mamallapuram", "Mamallapuram Police Station");
        policeStationMap.put("chengalpattu_thirukkazhukundram", "Thirukkazhukundram Police Station");
        policeStationMap.put("chengalpattu_pudupattinam", "Pudupattinam Police Station");
        policeStationMap.put("chengalpattu_paranur", "Paranur Police Station");
        policeStationMap.put("chengalpattu_sunguvarchatram", "Sunguvarchatram Police Station");
        policeStationMap.put("chengalpattu_kattankulathur", "Kattankulathur Police Station");
        policeStationMap.put("chengalpattu_semmencheri", "Semmencheri Police Station");

        // ==================== COIMBATORE DISTRICT ====================
        policeStationMap.put("coimbatore_coimbatore", "Coimbatore City Police");
        policeStationMap.put("coimbatore_peelamedu", "Peelamedu Police Station");
        policeStationMap.put("coimbatore_singanallur", "Singanallur Police Station");
        policeStationMap.put("coimbatore_pollachi", "Pollachi Police Station");
        policeStationMap.put("coimbatore_mettupalayam", "Mettupalayam Police Station");
        policeStationMap.put("coimbatore_annur", "Annur Police Station");
        policeStationMap.put("coimbatore_sulur", "Sulur Police Station");
        policeStationMap.put("coimbatore_kinathukadavu", "Kinathukadavu Police Station");
        policeStationMap.put("coimbatore_valparai", "Valparai Police Station");
        policeStationMap.put("coimbatore_palladam", "Palladam Police Station");
        policeStationMap.put("coimbatore_thondamuthur", "Thondamuthur Police Station");
        policeStationMap.put("coimbatore_madukkarai", "Madukkarai Police Station");
        policeStationMap.put("coimbatore_perur", "Perur Police Station");
        policeStationMap.put("coimbatore_kuniyamuthur", "Kuniyamuthur Police Station");
        policeStationMap.put("coimbatore_saravanampatti", "Saravanampatti Police Station");
        policeStationMap.put("coimbatore_rs puram", "R.S. Puram Police Station");
        policeStationMap.put("coimbatore_ganapathy", "Ganapathy Police Station");
        policeStationMap.put("coimbatore_uthukuli", "Uthukuli Police Station");

        // ==================== CUDDALORE DISTRICT ====================
        policeStationMap.put("cuddalore_cuddalore", "Cuddalore Police Station");
        policeStationMap.put("cuddalore_chidambaram", "Chidambaram Police Station");
        policeStationMap.put("cuddalore_vriddhachalam", "Vriddhachalam Police Station");
        policeStationMap.put("cuddalore_panruti", "Panruti Police Station");
        policeStationMap.put("cuddalore_kurinjipadi", "Kurinjipadi Police Station");
        policeStationMap.put("cuddalore_veeranam", "Veeranam Police Station");
        policeStationMap.put("cuddalore_kattumannarkoil", "Kattumannarkoil Police Station");
        policeStationMap.put("cuddalore_srimushnam", "Srimushnam Police Station");
        policeStationMap.put("cuddalore_tittagudi", "Tittagudi Police Station");
        policeStationMap.put("cuddalore_parangipettai", "Parangipettai Police Station");
        policeStationMap.put("cuddalore_bhuvanagiri", "Bhuvanagiri Police Station");
        policeStationMap.put("cuddalore_sethiathope", "Sethiathope Police Station");
        policeStationMap.put("cuddalore_mangalampet", "Mangalampet Police Station");
        policeStationMap.put("cuddalore_nellikuppam", "Nellikuppam Police Station");
        policeStationMap.put("cuddalore_keerapalayam", "Keerapalayam Police Station");

        // ==================== DHARMAPURI DISTRICT ====================
        policeStationMap.put("dharmapuri_dharmapuri", "Dharmapuri Police Station");
        policeStationMap.put("dharmapuri_harur", "Harur Police Station");
        policeStationMap.put("dharmapuri_palacode", "Palacode Police Station");
        policeStationMap.put("dharmapuri_marandahalli", "Marandahalli Police Station");
        policeStationMap.put("dharmapuri_kadathur", "Kadathur Police Station");
        policeStationMap.put("dharmapuri_karimangalam", "Karimangalam Police Station");
        policeStationMap.put("dharmapuri_morappur", "Morappur Police Station");
        policeStationMap.put("dharmapuri_pappireddipatti", "Pappireddipatti Police Station");
        policeStationMap.put("dharmapuri_nerippanur", "Nerippanur Police Station");
        policeStationMap.put("dharmapuri_bommidi", "Bommidi Police Station");
        policeStationMap.put("dharmapuri_thoppur", "Thoppur Police Station");
        policeStationMap.put("dharmapuri_eriyur", "Eriyur Police Station");
        policeStationMap.put("dharmapuri_indur", "Indur Police Station");
        policeStationMap.put("dharmapuri_mulagumudu", "Mulagumudu Police Station");
        policeStationMap.put("dharmapuri_sivadi", "Sivadi Police Station");

        // ==================== DINDIGUL DISTRICT ====================
        policeStationMap.put("dindigul_dindigul", "Dindigul Police Station");
        policeStationMap.put("dindigul_kodaikanal", "Kodaikanal Police Station");
        policeStationMap.put("dindigul_palani", "Palani Police Station");
        policeStationMap.put("dindigul_vedasandur", "Vedasandur Police Station");
        policeStationMap.put("dindigul_natham", "Natham Police Station");
        policeStationMap.put("dindigul_nilakottai", "Nilakottai Police Station");
        policeStationMap.put("dindigul_oddanchatram", "Oddanchatram Police Station");
        policeStationMap.put("dindigul_ayyalur", "Ayyalur Police Station");
        policeStationMap.put("dindigul_vadamadurai", "Vadamadurai Police Station");
        policeStationMap.put("dindigul_guziliamparai", "Guziliamparai Police Station");
        policeStationMap.put("dindigul_ambathurai", "Ambathurai Police Station");
        policeStationMap.put("dindigul_sanarpatti", "Sanarpatti Police Station");
        policeStationMap.put("dindigul_thoppampatti", "Thoppampatti Police Station");
        policeStationMap.put("dindigul_vattalkundu", "Vattalkundu Police Station");
        policeStationMap.put("dindigul_kanavaipatti", "Kanavaipatti Police Station");

        // ==================== ERODE DISTRICT ====================
        policeStationMap.put("erode_erode", "Erode Police Station");
        policeStationMap.put("erode_gobichettipalayam", "Gobichettipalayam Police Station");
        policeStationMap.put("erode_sathyamangalam", "Sathyamangalam Police Station");
        policeStationMap.put("erode_bhavani", "Bhavani Police Station");
        policeStationMap.put("erode_perundurai", "Perundurai Police Station");
        policeStationMap.put("erode_kodumudi", "Kodumudi Police Station");
        policeStationMap.put("erode_anthiyur", "Anthiyur Police Station");
        policeStationMap.put("erode_modakurichi", "Modakurichi Police Station");
        policeStationMap.put("erode_kavandapadi", "Kavandapadi Police Station");
        policeStationMap.put("erode_nambiyur", "Nambiyur Police Station");
        policeStationMap.put("erode_thalavadi", "Thalavadi Police Station");
        policeStationMap.put("erode_punjai puliyampatti", "Punjai Puliyampatti Police Station");
        policeStationMap.put("erode_ammapet", "Ammapet Police Station");
        policeStationMap.put("erode_chithode", "Chithode Police Station");
        policeStationMap.put("erode_surampatti", "Surampatti Police Station");

        // ==================== KALLAKURICHI DISTRICT ====================
        policeStationMap.put("kallakurichi_kallakurichi", "Kallakurichi Police Station");
        policeStationMap.put("kallakurichi_tirukoilur", "Tirukoilur Police Station");
        policeStationMap.put("kallakurichi_sankarapuram", "Sankarapuram Police Station");
        policeStationMap.put("kallakurichi_ulundurpet", "Ulundurpet Police Station");
        policeStationMap.put("kallakurichi_chinnasalem", "Chinnasalem Police Station");
        policeStationMap.put("kallakurichi_kalvarayan hills", "Kalvarayan Hills Police Station");
        policeStationMap.put("kallakurichi_soorapattu", "Soorapattu Police Station");
        policeStationMap.put("kallakurichi_rastampettai", "Rastampettai Police Station");
        policeStationMap.put("kallakurichi_melur", "Melur Police Station");
        policeStationMap.put("kallakurichi_thirunavalur", "Thirunavalur Police Station");
        policeStationMap.put("kallakurichi_manalurpet", "Manalurpet Police Station");
        policeStationMap.put("kallakurichi_therani", "Therani Police Station");
        policeStationMap.put("kallakurichi_mugaiyur", "Mugaiyur Police Station");
        policeStationMap.put("kallakurichi_thiagadurgam", "Thiagadurgam Police Station");
        policeStationMap.put("kallakurichi_kachirampalayam", "Kachirampalayam Police Station");

        // ==================== KANCHIPURAM DISTRICT ====================
        policeStationMap.put("kancheepuram_kancheepuram", "Kancheepuram Police Station");
        policeStationMap.put("kancheepuram_sriperumbudur", "Sriperumbudur Police Station");
        policeStationMap.put("kancheepuram_uthiramerur", "Uthiramerur Police Station");
        policeStationMap.put("kancheepuram_kundrathur", "Kundrathur Police Station");
        policeStationMap.put("kancheepuram_mangadu", "Mangadu Police Station");
        policeStationMap.put("kancheepuram_poonamallee", "Poonamallee Police Station");
        policeStationMap.put("kancheepuram_walajabad", "Walajabad Police Station");
        policeStationMap.put("kancheepuram_sevilimedu", "Sevilimedu Police Station");
        policeStationMap.put("kancheepuram_orkkadam", "Orkkadam Police Station");
        policeStationMap.put("kancheepuram_manimangalam", "Manimangalam Police Station");
        policeStationMap.put("kancheepuram_sunguvarchatram", "Sunguvarchatram Police Station");
        policeStationMap.put("kancheepuram_thiruporur", "Thiruporur Police Station");
        policeStationMap.put("kancheepuram_cheyyur", "Cheyyur Police Station");
        policeStationMap.put("kancheepuram_madurantakam", "Madurantakam Police Station");
        policeStationMap.put("kancheepuram_karunguzhi", "Karunguzhi Police Station");

        // ==================== KANYAKUMARI DISTRICT ====================
        policeStationMap.put("kanyakumari_nagercoil", "Nagercoil Police Station");
        policeStationMap.put("kanyakumari_kanyakumari", "Kanyakumari Police Station");
        policeStationMap.put("kanyakumari_marthandam", "Marthandam Police Station");
        policeStationMap.put("kanyakumari_kuzhithurai", "Kuzhithurai Police Station");
        policeStationMap.put("kanyakumari_padmanabhapuram", "Padmanabhapuram Police Station");
        policeStationMap.put("kanyakumari_thuckalay", "Thuckalay Police Station");
        policeStationMap.put("kanyakumari_kollencode", "Kollencode Police Station");
        policeStationMap.put("kanyakumari_karungal", "Karungal Police Station");
        policeStationMap.put("kanyakumari_killiyur", "Killiyur Police Station");
        policeStationMap.put("kanyakumari_rajakkamangalam", "Rajakkamangalam Police Station");
        policeStationMap.put("kanyakumari_kurunthencode", "Kurunthencode Police Station");
        policeStationMap.put("kanyakumari_puthalam", "Puthalam Police Station");
        policeStationMap.put("kanyakumari_eraviputhenthurai", "Eraviputhenthurai Police Station");
        policeStationMap.put("kanyakumari_midalam", "Midalam Police Station");
        policeStationMap.put("kanyakumari_pechipparai", "Pechipparai Police Station");

        // ==================== KARUR DISTRICT ====================
        policeStationMap.put("karur_karur", "Karur Police Station");
        policeStationMap.put("karur_kulithalai", "Kulithalai Police Station");
        policeStationMap.put("karur_thogamalai", "Thogamalai Police Station");
        policeStationMap.put("karur_aravakurichi", "Aravakurichi Police Station");
        policeStationMap.put("karur_pallapatti", "Pallapatti Police Station");
        policeStationMap.put("karur_krishnarayapuram", "Krishnarayapuram Police Station");
        policeStationMap.put("karur_kadavur", "Kadavur Police Station");
        policeStationMap.put("karur_vangal", "Vangal Police Station");
        policeStationMap.put("karur_inungalur", "Inungalur Police Station");
        policeStationMap.put("karur_thanthoni", "Thanthoni Police Station");
        policeStationMap.put("karur_puliyur", "Puliyur Police Station");
        policeStationMap.put("karur_nerur", "Nerur Police Station");
        policeStationMap.put("karur_velayuthampalayam", "Velayuthampalayam Police Station");
        policeStationMap.put("karur_mayanur", "Mayanur Police Station");
        policeStationMap.put("karur_k.pudupatti", "K.Pudupatti Police Station");

        // ==================== KRISHNAGIRI DISTRICT ====================
        policeStationMap.put("krishnagiri_krishnagiri", "Krishnagiri Police Station");
        policeStationMap.put("krishnagiri_hosur", "Hosur Police Station");
        policeStationMap.put("krishnagiri_denkanikottai", "Denkanikottai Police Station");
        policeStationMap.put("krishnagiri_pochampalli", "Pochampalli Police Station");
        policeStationMap.put("krishnagiri_uthangarai", "Uthangarai Police Station");
        policeStationMap.put("krishnagiri_shoolagiri", "Shoolagiri Police Station");
        policeStationMap.put("krishnagiri_bargur", "Bargur Police Station");
        policeStationMap.put("krishnagiri_kaveripattinam", "Kaveripattinam Police Station");
        policeStationMap.put("krishnagiri_veppanapalli", "Veppanapalli Police Station");
        policeStationMap.put("krishnagiri_mathur", "Mathur Police Station");
        policeStationMap.put("krishnagiri_kelamangalam", "Kelamangalam Police Station");
        policeStationMap.put("krishnagiri_thally", "Thally Police Station");
        policeStationMap.put("krishnagiri_samalpatti", "Samalpatti Police Station");
        policeStationMap.put("krishnagiri_nerkundram", "Nerkundram Police Station");
        policeStationMap.put("krishnagiri_mookandapalli", "Mookandapalli Police Station");

        // ==================== MADURAI DISTRICT ====================
        policeStationMap.put("madurai_madurai", "Madurai City Police");
        policeStationMap.put("madurai_thirumangalam", "Thirumangalam Police Station");
        policeStationMap.put("madurai_usilampatti", "Usilampatti Police Station");
        policeStationMap.put("madurai_melur", "Melur Police Station");
        policeStationMap.put("madurai_vadipatti", "Vadipatti Police Station");
        policeStationMap.put("madurai_sholavandan", "Sholavandan Police Station");
        policeStationMap.put("madurai_peraiyur", "Peraiyur Police Station");
        policeStationMap.put("madurai_kallikudi", "Kallikudi Police Station");
        policeStationMap.put("madurai_thirupparankundram", "Thirupparankundram Police Station");
        policeStationMap.put("madurai_alanganallur", "Alanganallur Police Station");
        policeStationMap.put("madurai_t.kallupatti", "T.Kallupatti Police Station");
        policeStationMap.put("madurai_sedapatti", "Sedapatti Police Station");
        policeStationMap.put("madurai_kottampatti", "Kottampatti Police Station");
        policeStationMap.put("madurai_chellampatti", "Chellampatti Police Station");
        policeStationMap.put("madurai_mangulam", "Mangulam Police Station");
        policeStationMap.put("madurai_annai nagar", "Annai Nagar Police Station");
        policeStationMap.put("madurai_k pudur", "K. Pudur Police Station");

        // ==================== MAYILADUTHURAI DISTRICT ====================
        policeStationMap.put("mayiladuthurai_mayiladuthurai", "Mayiladuthurai Police Station");
        policeStationMap.put("mayiladuthurai_sirkazhi", "Sirkazhi Police Station");
        policeStationMap.put("mayiladuthurai_manampathy", "Manampathy Police Station");
        policeStationMap.put("mayiladuthurai_poonthottam", "Poonthottam Police Station");
        policeStationMap.put("mayiladuthurai_kuthalam", "Kuthalam Police Station");
        policeStationMap.put("mayiladuthurai_sembanarkoil", "Sembanarkoil Police Station");
        policeStationMap.put("mayiladuthurai_tharangambadi", "Tharangambadi Police Station");
        policeStationMap.put("mayiladuthurai_kozhikudi", "Kozhikudi Police Station");
        policeStationMap.put("mayiladuthurai_manalmedu", "Manalmedu Police Station");
        policeStationMap.put("mayiladuthurai_korukkai", "Korukkai Police Station");
        policeStationMap.put("mayiladuthurai_mangaimadam", "Mangaimadam Police Station");
        policeStationMap.put("mayiladuthurai_muttam", "Muttam Police Station");
        policeStationMap.put("mayiladuthurai_thiruvengadu", "Thiruvengadu Police Station");
        policeStationMap.put("mayiladuthurai_keezhaiyur", "Keezhaiyur Police Station");
        policeStationMap.put("mayiladuthurai_vazhkai", "Vazhkai Police Station");

        // ==================== NAGAPATTINAM DISTRICT ====================
        policeStationMap.put("nagapattinam_nagapattinam", "Nagapattinam Police Station");
        policeStationMap.put("nagapattinam_vedaranyam", "Vedaranyam Police Station");
        policeStationMap.put("nagapattinam_thiruvarur", "Thiruvarur Police Station");
        policeStationMap.put("nagapattinam_mannargudi", "Mannargudi Police Station");
        policeStationMap.put("nagapattinam_nannilam", "Nannilam Police Station");
        policeStationMap.put("nagapattinam_kilvelur", "Kilvelur Police Station");
        policeStationMap.put("nagapattinam_thalainayar", "Thalainayar Police Station");
        policeStationMap.put("nagapattinam_kechankuppam", "Kechankuppam Police Station");
        policeStationMap.put("nagapattinam_akkaraipettai", "Akkaraipettai Police Station");
        policeStationMap.put("nagapattinam_porayar", "Porayar Police Station");
        policeStationMap.put("nagapattinam_kodikarai", "Kodikarai Police Station");
        policeStationMap.put("nagapattinam_thirumarugal", "Thirumarugal Police Station");
        policeStationMap.put("nagapattinam_ettukudi", "Ettukudi Police Station");
        policeStationMap.put("nagapattinam_velankanni", "Velankanni Police Station");
        policeStationMap.put("nagapattinam_nagakudi", "Nagakudi Police Station");

        // ==================== NAMAKKAL DISTRICT ====================
        policeStationMap.put("namakkal_namakkal", "Namakkal Police Station");
        policeStationMap.put("namakkal_tiruchengode", "Tiruchengode Police Station");
        policeStationMap.put("namakkal_rasipuram", "Rasipuram Police Station");
        policeStationMap.put("namakkal_kumarapalayam", "Kumarapalayam Police Station");
        policeStationMap.put("namakkal_paramathi", "Paramathi Police Station");
        policeStationMap.put("namakkal_sendamangalam", "Sendamangalam Police Station");
        policeStationMap.put("namakkal_mohanur", "Mohanur Police Station");
        policeStationMap.put("namakkal_namagiripettai", "Namagiripettai Police Station");
        policeStationMap.put("namakkal_erumapatti", "Erumapatti Police Station");
        policeStationMap.put("namakkal_pallipalayam", "Pallipalayam Police Station");
        policeStationMap.put("namakkal_komarapalayam", "Komarapalayam Police Station");
        policeStationMap.put("namakkal_vazhapadi", "Vazhapadi Police Station");
        policeStationMap.put("namakkal_kabilarmalai", "Kabilarmalai Police Station");
        policeStationMap.put("namakkal_mallasamudram", "Mallasamudram Police Station");
        policeStationMap.put("namakkal_venandur", "Venandur Police Station");

        // ==================== NILGIRIS DISTRICT ====================
        policeStationMap.put("nilgiris_ooty", "Ooty Police Station");
        policeStationMap.put("nilgiris_koonoor", "Koonoor Police Station");
        policeStationMap.put("nilgiris_gudalur", "Gudalur Police Station");
        policeStationMap.put("nilgiris_kotagiri", "Kotagiri Police Station");
        policeStationMap.put("nilgiris_coonoor", "Coonoor Police Station");
        policeStationMap.put("nilgiris_wellington", "Wellington Police Station");
        policeStationMap.put("nilgiris_adanakatti", "Adanakatti Police Station");
        policeStationMap.put("nilgiris_manjoor", "Manjoor Police Station");
        policeStationMap.put("nilgiris_kethi", "Kethi Police Station");
        policeStationMap.put("nilgiris_hubbathalai", "Hubbathalai Police Station");
        policeStationMap.put("nilgiris_denad", "Denad Police Station");
        policeStationMap.put("nilgiris_kagguchi", "Kagguchi Police Station");
        policeStationMap.put("nilgiris_erumad", "Erumad Police Station");
        policeStationMap.put("nilgiris_thalayathimund", "Thalayathimund Police Station");
        policeStationMap.put("nilgiris_parlikal", "Parlikal Police Station");

        // ==================== PERAMBALUR DISTRICT ====================
        policeStationMap.put("perambalur_perambalur", "Perambalur Police Station");
        policeStationMap.put("perambalur_veeraganur", "Veeraganur Police Station");
        policeStationMap.put("perambalur_kunnam", "Kunnam Police Station");
        policeStationMap.put("perambalur_alathur", "Alathur Police Station");
        policeStationMap.put("perambalur_aranarai", "Aranarai Police Station");
        policeStationMap.put("perambalur_esanai", "Esanai Police Station");
        policeStationMap.put("perambalur_kurumbalur", "Kurumbalur Police Station");
        policeStationMap.put("perambalur_ladapuram", "Ladapuram Police Station");
        policeStationMap.put("perambalur_venbavur", "Venbavur Police Station");
        policeStationMap.put("perambalur_murukkambadi", "Murukkambadi Police Station");
        policeStationMap.put("perambalur_keelapuliyur", "Keelapuliyur Police Station");
        policeStationMap.put("perambalur_olakkur", "Olakkur Police Station");
        policeStationMap.put("perambalur_paravai", "Paravai Police Station");
        policeStationMap.put("perambalur_thirumanur", "Thirumanur Police Station");
        policeStationMap.put("perambalur_mangalamedu", "Mangalamedu Police Station");

        // ==================== PUDUKKOTTAI DISTRICT ====================
        policeStationMap.put("pudukkottai_pudukkottai", "Pudukkottai Police Station");
        policeStationMap.put("pudukkottai_aranthangi", "Aranthangi Police Station");
        policeStationMap.put("pudukkottai_karambakudi", "Karambakudi Police Station");
        policeStationMap.put("pudukkottai_keeramangalam", "Keeramangalam Police Station");
        policeStationMap.put("pudukkottai_ponnamaravathy", "Ponnamaravathy Police Station");
        policeStationMap.put("pudukkottai_thirumayam", "Thirumayam Police Station");
        policeStationMap.put("pudukkottai_iluppur", "Iluppur Police Station");
        policeStationMap.put("pudukkottai_avudayarkoil", "Avudayarkoil Police Station");
        policeStationMap.put("pudukkottai_kulathur", "Kulathur Police Station");
        policeStationMap.put("pudukkottai_gandarvakottai", "Gandarvakottai Police Station");
        policeStationMap.put("pudukkottai_manamelkudi", "Manamelkudi Police Station");
        policeStationMap.put("pudukkottai_minnathur", "Minnathur Police Station");
        policeStationMap.put("pudukkottai_annanagar", "Annanagar Police Station");
        policeStationMap.put("pudukkottai_viralimalai", "Viralimalai Police Station");
        policeStationMap.put("pudukkottai_kundrandarkoil", "Kundrandarkoil Police Station");

        // ==================== RAMANATHAPURAM DISTRICT ====================
        policeStationMap.put("ramanathapuram_ramanathapuram", "Ramanathapuram Police Station");
        policeStationMap.put("ramanathapuram_paramakudi", "Paramakudi Police Station");
        policeStationMap.put("ramanathapuram_keelakarai", "Keelakarai Police Station");
        policeStationMap.put("ramanathapuram_rameshwaram", "Rameshwaram Police Station");
        policeStationMap.put("ramanathapuram_mudukulathur", "Mudukulathur Police Station");
        policeStationMap.put("ramanathapuram_kamuthi", "Kamuthi Police Station");
        policeStationMap.put("ramanathapuram_thiruvadanai", "Thiruvadanai Police Station");
        policeStationMap.put("ramanathapuram_rajasingamangalam", "Rajasingamangalam Police Station");
        policeStationMap.put("ramanathapuram_sayalkudi", "Sayalkudi Police Station");
        policeStationMap.put("ramanathapuram_erwadi", "Erwadi Police Station");
        policeStationMap.put("ramanathapuram_thalavoor", "Thalavoor Police Station");
        policeStationMap.put("ramanathapuram_avaniam", "Avaniam Police Station");
        policeStationMap.put("ramanathapuram_bogalur", "Bogalur Police Station");
        policeStationMap.put("ramanathapuram_narippaiyur", "Narippaiyur Police Station");
        policeStationMap.put("ramanathapuram_vedhalai", "Vedhalai Police Station");

        // ==================== RANIPET DISTRICT ====================
        policeStationMap.put("ranipet_ranipet", "Ranipet Police Station");
        policeStationMap.put("ranipet_arcot", "Arcot Police Station");
        policeStationMap.put("ranipet_walajapet", "Walajapet Police Station");
        policeStationMap.put("ranipet_ambur", "Ambur Police Station");
        policeStationMap.put("ranipet_vaniyambadi", "Vaniyambadi Police Station");
        policeStationMap.put("ranipet_nemili", "Nemili Police Station");
        policeStationMap.put("ranipet_timiri", "Timiri Police Station");
        policeStationMap.put("ranipet_a.kondur", "A.Kondur Police Station");
        policeStationMap.put("ranipet_melvisharam", "Melvisharam Police Station");
        policeStationMap.put("ranipet_sholingur", "Sholingur Police Station");
        policeStationMap.put("ranipet_banavaram", "Banavaram Police Station");
        policeStationMap.put("ranipet_kalavai", "Kalavai Police Station");
        policeStationMap.put("ranipet_thiruvalam", "Thiruvalam Police Station");
        policeStationMap.put("ranipet_mullipattu", "Mullipattu Police Station");
        policeStationMap.put("ranipet_kannamangalam", "Kannamangalam Police Station");

        // ==================== SALEM DISTRICT ====================
        policeStationMap.put("salem_salem", "Salem City Police");
        policeStationMap.put("salem_attur", "Attur Police Station");
        policeStationMap.put("salem_mettur", "Mettur Police Station");
        policeStationMap.put("salem_sankagiri", "Sankagiri Police Station");
        policeStationMap.put("salem_edappadi", "Edappadi Police Station");
        policeStationMap.put("salem_ompalayam", "Ompalayam Police Station");
        policeStationMap.put("salem_tharamangalam", "Tharamangalam Police Station");
        policeStationMap.put("salem_kondalampatti", "Kondalampatti Police Station");
        policeStationMap.put("salem_veerapandi", "Veerapandi Police Station");
        policeStationMap.put("salem_ayothiyapattinam", "Ayothiyapattinam Police Station");
        policeStationMap.put("salem_thalavasai", "Thalavasai Police Station");
        policeStationMap.put("salem_poolampatti", "Poolampatti Police Station");
        policeStationMap.put("salem_karumandurai", "Karumandurai Police Station");
        policeStationMap.put("salem_kadayampatti", "Kadayampatti Police Station");
        policeStationMap.put("salem_vazhapadi", "Vazhapadi Police Station");
        policeStationMap.put("salem_hasthampatti", "Hasthampatti Police Station");
        policeStationMap.put("salem_ammapet", "Ammapet Police Station");

        // ==================== SIVAGANGAI DISTRICT ====================
        policeStationMap.put("sivagangai_sivagangai", "Sivagangai Police Station");
        policeStationMap.put("sivagangai_karaikudi", "Karaikudi Police Station");
        policeStationMap.put("sivagangai_devakottai", "Devakottai Police Station");
        policeStationMap.put("sivagangai_manamadurai", "Manamadurai Police Station");
        policeStationMap.put("sivagangai_ilayangudi", "Ilayangudi Police Station");
        policeStationMap.put("sivagangai_thirupathur", "Thirupathur Police Station");
        policeStationMap.put("sivagangai_kallal", "Kallal Police Station");
        policeStationMap.put("sivagangai_singampunari", "Singampunari Police Station");
        policeStationMap.put("sivagangai_kalayarkoil", "Kalayarkoil Police Station");
        policeStationMap.put("sivagangai_kandanur", "Kandanur Police Station");
        policeStationMap.put("sivagangai_sakkottai", "Sakkottai Police Station");
        policeStationMap.put("sivagangai_puduvayal", "Puduvayal Police Station");
        policeStationMap.put("sivagangai_nattarasankottai", "Nattarasankottai Police Station");
        policeStationMap.put("sivagangai_kottaiyur", "Kottaiyur Police Station");
        policeStationMap.put("sivagangai_thirukostiyur", "Thirukostiyur Police Station");

        // ==================== TENKASI DISTRICT ====================
        policeStationMap.put("tenkasi_tenkasi", "Tenkasi Police Station");
        policeStationMap.put("tenkasi_sankarankovil", "Sankarankovil Police Station");
        policeStationMap.put("tenkasi_kadayanallur", "Kadayanallur Police Station");
        policeStationMap.put("tenkasi_shenkottai", "Shenkottai Police Station");
        policeStationMap.put("tenkasi_puliyangudi", "Puliyangudi Police Station");
        policeStationMap.put("tenkasi_veerakeralampudur", "Veerakeralampudur Police Station");
        policeStationMap.put("tenkasi_ilaiyangudi", "Ilaiyangudi Police Station");
        policeStationMap.put("tenkasi_keelapavoor", "Keelapavoor Police Station");
        policeStationMap.put("tenkasi_kuruvikulam", "Kuruvikulam Police Station");
        policeStationMap.put("tenkasi_melagaram", "Melagaram Police Station");
        policeStationMap.put("tenkasi_ayikudi", "Ayikudi Police Station");
        policeStationMap.put("tenkasi_sundarapandiapuram", "Sundarapandiapuram Police Station");
        policeStationMap.put("tenkasi_thalmai", "Thalmai Police Station");
        policeStationMap.put("tenkasi_panpozhi", "Panpozhi Police Station");
        policeStationMap.put("tenkasi_sivagiri", "Sivagiri Police Station");

        // ==================== THANJAVUR DISTRICT ====================
        policeStationMap.put("thanjavur_thanjavur", "Thanjavur Police Station");
        policeStationMap.put("thanjavur_kumbakonam", "Kumbakonam Police Station");
        policeStationMap.put("thanjavur_pattukkottai", "Pattukkottai Police Station");
        policeStationMap.put("thanjavur_needamangalam", "Needamangalam Police Station");
        policeStationMap.put("thanjavur_thirukattupalli", "Thirukattupalli Police Station");
        policeStationMap.put("thanjavur_ammapettai", "Ammapettai Police Station");
        policeStationMap.put("thanjavur_papanasam", "Papanasam Police Station");
        policeStationMap.put("thanjavur_thiruvaiyaru", "Thiruvaiyaru Police Station");
        policeStationMap.put("thanjavur_orangallur", "Orangallur Police Station");
        policeStationMap.put("thanjavur_vallam", "Vallam Police Station");
        policeStationMap.put("thanjavur_adanur", "Adanur Police Station");
        policeStationMap.put("thanjavur_budalur", "Budalur Police Station");
        policeStationMap.put("thanjavur_thiruppanandal", "Thiruppanandal Police Station");
        policeStationMap.put("thanjavur_madukkur", "Madukkur Police Station");
        policeStationMap.put("thanjavur_sethubhavachatram", "Sethubhavachatram Police Station");

        // ==================== THENI DISTRICT ====================
        policeStationMap.put("theni_theni", "Theni Police Station");
        policeStationMap.put("theni_periyakulam", "Periyakulam Police Station");
        policeStationMap.put("theni_cumbum", "Cumbum Police Station");
        policeStationMap.put("theni_gudalur", "Gudalur Police Station");
        policeStationMap.put("theni_chinnamanur", "Chinnamanur Police Station");
        policeStationMap.put("theni_andalipuram", "Andalipuram Police Station");
        policeStationMap.put("theni_kambam", "Kambam Police Station");
        policeStationMap.put("theni_myladumparai", "Myladumparai Police Station");
        policeStationMap.put("theni_kaniyar", "Kaniyar Police Station");
        policeStationMap.put("theni_kuchanur", "Kuchanur Police Station");
        policeStationMap.put("theni_vegapandi", "Vegapandi Police Station");
        policeStationMap.put("theni_bodinayakanur", "Bodinayakanur Police Station");
        policeStationMap.put("theni_uthamapalayam", "Uthamapalayam Police Station");
        policeStationMap.put("theni_teekkar", "Teekkar Police Station");
        policeStationMap.put("theni_oddanchatram", "Oddanchatram Police Station");

        // ==================== THOOTHUKUDI DISTRICT ====================
        policeStationMap.put("thoothukudi_thoothukudi", "Thoothukudi Police Station");
        policeStationMap.put("thoothukudi_kayalpattinam", "Kayalpattinam Police Station");
        policeStationMap.put("thoothukudi_kovilpatti", "Kovilpatti Police Station");
        policeStationMap.put("thoothukudi_oththapidaram", "Oththapidaram Police Station");
        policeStationMap.put("thoothukudi_ettayapuram", "Ettayapuram Police Station");
        policeStationMap.put("thoothukudi_vilathikulam", "Vilathikulam Police Station");
        policeStationMap.put("thoothukudi_ottapidaram", "Ottapidaram Police Station");
        policeStationMap.put("thoothukudi_sathankulam", "Sathankulam Police Station");
        policeStationMap.put("thoothukudi_srivaikuntam", "Srivaikuntam Police Station");
        policeStationMap.put("thoothukudi_alwarthirunagari", "Alwarthirunagari Police Station");
        policeStationMap.put("thoothukudi_nazerath", "Nazerath Police Station");
        policeStationMap.put("thoothukudi_pudur", "Pudur Police Station");
        policeStationMap.put("thoothukudi_karungulam", "Karungulam Police Station");
        policeStationMap.put("thoothukudi_uthukuli", "Uthukuli Police Station");
        policeStationMap.put("thoothukudi_aranthangi", "Aranthangi Police Station");

        // ==================== TIRUCHIRAPPALLI DISTRICT ====================
        policeStationMap.put("trichy_tiruchirappalli", "Trichy City Police");
        policeStationMap.put("trichy_srirangam", "Srirangam Police Station");
        policeStationMap.put("trichy_thillai nagar", "Thillai Nagar Police Station");
        policeStationMap.put("trichy_cantonment", "Cantonment Police Station");
        policeStationMap.put("trichy_ponmalai", "Ponmalai Police Station");
        policeStationMap.put("trichy_golden rock", "Golden Rock Police Station");
        policeStationMap.put("trichy_edamalaipatti", "Edamalaipatti Police Station");
        policeStationMap.put("trichy_k.k.nagar", "K.K.Nagar Police Station");
        policeStationMap.put("trichy_uthamar gandhi", "Uthamar Gandhi Police Station");
        policeStationMap.put("trichy_manachanallur", "Manachanallur Police Station");
        policeStationMap.put("trichy_lalgudi", "Lalgudi Police Station");
        policeStationMap.put("trichy_thuvakudi", "Thuvakudi Police Station");
        policeStationMap.put("trichy_samayapuram", "Samayapuram Police Station");
        policeStationMap.put("trichy_musiri", "Musiri Police Station");
        policeStationMap.put("trichy_manapparai", "Manapparai Police Station");
        policeStationMap.put("trichy_thottiyam", "Thottiyam Police Station");

        // ==================== TIRUNELVELI DISTRICT ====================
        policeStationMap.put("tirunelveli_tirunelveli", "Tirunelveli City Police");
        policeStationMap.put("tirunelveli_palayamkottai", "Palayamkottai Police Station");
        policeStationMap.put("tirunelveli_melapalayam", "Melapalayam Police Station");
        policeStationMap.put("tirunelveli_thachanallur", "Thachanallur Police Station");
        policeStationMap.put("tirunelveli_pettai", "Pettai Police Station");
        policeStationMap.put("tirunelveli_kokkirakulam", "Kokkirakulam Police Station");
        policeStationMap.put("tirunelveli_ambasamudram", "Ambasamudram Police Station");
        policeStationMap.put("tirunelveli_vikramasingapuram", "Vikramasingapuram Police Station");
        policeStationMap.put("tirunelveli_kallidaikurichi", "Kallidaikurichi Police Station");
        policeStationMap.put("tirunelveli_cheranmahadevi", "Cheranmahadevi Police Station");
        policeStationMap.put("tirunelveli_thisayanvilai", "Thisayanvilai Police Station");
        policeStationMap.put("tirunelveli_nanguneri", "Nanguneri Police Station");
        policeStationMap.put("tirunelveli_radhapuram", "Radhapuram Police Station");
        policeStationMap.put("tirunelveli_sankarankovil", "Sankarankovil Police Station");
        policeStationMap.put("tirunelveli_tenkasi", "Tenkasi Police Station");
        policeStationMap.put("tirunelveli_shenkottai", "Shenkottai Police Station");

        // ==================== TIRUPATHUR DISTRICT ====================
        policeStationMap.put("tirupathur_tirupathur", "Tirupathur Police Station");
        policeStationMap.put("tirupathur_vaniyambadi", "Vaniyambadi Police Station");
        policeStationMap.put("tirupathur_ambur", "Ambur Police Station");
        policeStationMap.put("tirupathur_natrampalli", "Natrampalli Police Station");
        policeStationMap.put("tirupathur_jolarpettai", "Jolarpettai Police Station");
        policeStationMap.put("tirupathur_kandili", "Kandili Police Station");
        policeStationMap.put("tirupathur_madhanur", "Madhanur Police Station");
        policeStationMap.put("tirupathur_pallikonda", "Pallikonda Police Station");
        policeStationMap.put("tirupathur_elagiri", "Elagiri Police Station");
        policeStationMap.put("tirupathur_odalvadi", "Odalvadi Police Station");
        policeStationMap.put("tirupathur_parvathipuram", "Parvathipuram Police Station");
        policeStationMap.put("tirupathur_melsilupatti", "Melsilupatti Police Station");
        policeStationMap.put("tirupathur_thimmapettai", "Thimmapettai Police Station");
        policeStationMap.put("tirupathur_veerapanur", "Veerapanur Police Station");
        policeStationMap.put("tirupathur_kuppanatham", "Kuppanatham Police Station");

        // ==================== TIRUPPUR DISTRICT ====================
        policeStationMap.put("tiruppur_tiruppur", "Tiruppur Police Station");
        policeStationMap.put("tiruppur_avinashipalayam", "Avinashipalayam Police Station");
        policeStationMap.put("tiruppur_dharapuram", "Dharapuram Police Station");
        policeStationMap.put("tiruppur_udumalpet", "Udumalpet Police Station");
        policeStationMap.put("tiruppur_madathukulam", "Madathukulam Police Station");
        policeStationMap.put("tiruppur_kangeyam", "Kangeyam Police Station");
        policeStationMap.put("tiruppur_palladam", "Palladam Police Station");
        policeStationMap.put("tiruppur_mulanur", "Mulanur Police Station");
        policeStationMap.put("tiruppur_vellakovil", "Vellakovil Police Station");
        policeStationMap.put("tiruppur_kolathupalayam", "Kolathupalayam Police Station");
        policeStationMap.put("tiruppur_veerapandi", "Veerapandi Police Station");
        policeStationMap.put("tiruppur_samalapuram", "Samalapuram Police Station");
        policeStationMap.put("tiruppur_mangalam", "Mangalam Police Station");
        policeStationMap.put("tiruppur_kunnathur", "Kunnathur Police Station");
        policeStationMap.put("tiruppur_chettipalayam", "Chettipalayam Police Station");

        // ==================== TIRUVALLUR DISTRICT ====================
        policeStationMap.put("tiruvallur_tiruvallur", "Tiruvallur Police Station");
        policeStationMap.put("tiruvallur_ambattur", "Ambattur Police Station");
        policeStationMap.put("tiruvallur_avadi", "Avadi Police Station");
        policeStationMap.put("tiruvallur_poonamallee", "Poonamallee Police Station");
        policeStationMap.put("tiruvallur_thiruninravur", "Thiruninravur Police Station");
        policeStationMap.put("tiruvallur_tiruttani", "Tiruttani Police Station");
        policeStationMap.put("tiruvallur_gummidipoondi", "Gummidipoondi Police Station");
        policeStationMap.put("tiruvallur_ponneri", "Ponneri Police Station");
        policeStationMap.put("tiruvallur_minjur", "Minjur Police Station");
        policeStationMap.put("tiruvallur_red hills", "Red Hills Police Station");
        policeStationMap.put("tiruvallur_madhavaram", "Madhavaram Police Station");
        policeStationMap.put("tiruvallur_kadambathur", "Kadambathur Police Station");
        policeStationMap.put("tiruvallur_pallipattu", "Pallipattu Police Station");
        policeStationMap.put("tiruvallur_pulicat", "Pulicat Police Station");
        policeStationMap.put("tiruvallur_sholavaram", "Sholavaram Police Station");

        // ==================== TIRUVANNAMALAI DISTRICT ====================
        policeStationMap.put("tiruvannamalai_tiruvannamalai", "Tiruvannamalai Police Station");
        policeStationMap.put("tiruvannamalai_arani", "Arani Police Station");
        policeStationMap.put("tiruvannamalai_chettupattu", "Chettupattu Police Station");
        policeStationMap.put("tiruvannamalai_vandavasi", "Vandavasi Police Station");
        policeStationMap.put("tiruvannamalai_polur", "Polur Police Station");
        policeStationMap.put("tiruvannamalai_chengam", "Chengam Police Station");
        policeStationMap.put("tiruvannamalai_thandarampattu", "Thandarampattu Police Station");
        policeStationMap.put("tiruvannamalai_keelpennathur", "Keelpennathur Police Station");
        policeStationMap.put("tiruvannamalai_kanji", "Kanji Police Station");
        policeStationMap.put("tiruvannamalai_jawadhu hills", "Jawadhu Hills Police Station");
        policeStationMap.put("tiruvannamalai_ananthur", "Ananthur Police Station");
        policeStationMap.put("tiruvannamalai_peranamallur", "Peranamallur Police Station");
        policeStationMap.put("tiruvannamalai_vedanthavadi", "Vedanthavadi Police Station");
        policeStationMap.put("tiruvannamalai_kilpennathur", "Kilpennathur Police Station");
        policeStationMap.put("tiruvannamalai_melmalaiyanur", "Melmalaiyanur Police Station");

        // ==================== TIRUVARUR DISTRICT ====================
        policeStationMap.put("tiruvarur_tiruvarur", "Tiruvarur Police Station");
        policeStationMap.put("tiruvarur_mannargudi", "Mannargudi Police Station");
        policeStationMap.put("tiruvarur_nannilam", "Nannilam Police Station");
        policeStationMap.put("tiruvarur_kodavasal", "Kodavasal Police Station");
        policeStationMap.put("tiruvarur_needamangalam", "Needamangalam Police Station");
        policeStationMap.put("tiruvarur_korukkai", "Korukkai Police Station");
        policeStationMap.put("tiruvarur_kottur", "Kottur Police Station");
        policeStationMap.put("tiruvarur_muthupettai", "Muthupettai Police Station");
        policeStationMap.put("tiruvarur_valangaiman", "Valangaiman Police Station");
        policeStationMap.put("tiruvarur_alundur", "Alundur Police Station");
        policeStationMap.put("tiruvarur_karuvakkurichi", "Karuvakkurichi Police Station");
        policeStationMap.put("tiruvarur_thirukannamangai", "Thirukannamangai Police Station");
        policeStationMap.put("tiruvarur_thiruthuraipoondi", "Thiruthuraipoondi Police Station");
        policeStationMap.put("tiruvarur_puthagaram", "Puthagaram Police Station");
        policeStationMap.put("tiruvarur_mavur", "Mavur Police Station");

        // ==================== VELLORE DISTRICT ====================
        policeStationMap.put("vellore_vellore", "Vellore City Police");
        policeStationMap.put("vellore_katpadi", "Katpadi Police Station");
        policeStationMap.put("vellore_ranipet", "Ranipet Police Station");
        policeStationMap.put("vellore_arcot", "Arcot Police Station");
        policeStationMap.put("vellore_walajapet", "Walajapet Police Station");
        policeStationMap.put("vellore_gudiyatham", "Gudiyatham Police Station");
        policeStationMap.put("vellore_vaniyambadi", "Vaniyambadi Police Station");
        policeStationMap.put("vellore_ambur", "Ambur Police Station");
        policeStationMap.put("vellore_pernampet", "Pernampet Police Station");
        policeStationMap.put("vellore_kalavai", "Kalavai Police Station");
        policeStationMap.put("vellore_sholinghur", "Sholinghur Police Station");
        policeStationMap.put("vellore_nemili", "Nemili Police Station");
        policeStationMap.put("vellore_oyyur", "Oyyur Police Station");
        policeStationMap.put("vellore_kandili", "Kandili Police Station");
        policeStationMap.put("vellore_madhanur", "Madhanur Police Station");

        // ==================== VILLUPURAM DISTRICT ====================
        policeStationMap.put("villupuram_villupuram", "Villupuram Police Station");
        policeStationMap.put("villupuram_tindivanam", "Tindivanam Police Station");
        policeStationMap.put("villupuram_gingee", "Gingee Police Station");
        policeStationMap.put("villupuram_vikravandi", "Vikravandi Police Station");
        policeStationMap.put("villupuram_vanur", "Vanur Police Station");
        policeStationMap.put("villupuram_marakkanam", "Marakkanam Police Station");
        policeStationMap.put("villupuram_mailam", "Mailam Police Station");
        policeStationMap.put("villupuram_melmalayanur", "Melmalayanur Police Station");
        policeStationMap.put("villupuram_koliyanur", "Koliyanur Police Station");
        policeStationMap.put("villupuram_kandachipuram", "Kandachipuram Police Station");
        policeStationMap.put("villupuram_mundiyambakkam", "Mundiyambakkam Police Station");
        policeStationMap.put("villupuram_thirukoilur", "Thirukoilur Police Station");
        policeStationMap.put("villupuram_ulagankathan", "Ulagankathan Police Station");
        policeStationMap.put("villupuram_mamallapuram", "Mamallapuram Police Station");
        policeStationMap.put("villupuram_kanjanur", "Kanjanur Police Station");

        // ==================== VIRUDHUNAGAR DISTRICT ====================
        policeStationMap.put("virudhunagar_virudhunagar", "Virudhunagar Police Station");
        policeStationMap.put("virudhunagar_sivakasi", "Sivakasi Police Station");
        policeStationMap.put("virudhunagar_srivilliputhur", "Srivilliputhur Police Station");
        policeStationMap.put("virudhunagar_rajapalayam", "Rajapalayam Police Station");
        policeStationMap.put("virudhunagar_sattur", "Sattur Police Station");
        policeStationMap.put("virudhunagar_aruppukottai", "Aruppukottai Police Station");
        policeStationMap.put("virudhunagar_kariapatti", "Kariapatti Police Station");
        policeStationMap.put("virudhunagar_tiruchuli", "Tiruchuli Police Station");
        policeStationMap.put("virudhunagar_narikkudi", "Narikkudi Police Station");
        policeStationMap.put("virudhunagar_mallankinaru", "Mallankinaru Police Station");
        policeStationMap.put("virudhunagar_watrap", "Watrap Police Station");
        policeStationMap.put("virudhunagar_chettikurichi", "Chettikurichi Police Station");
        policeStationMap.put("virudhunagar_seithur", "Seithur Police Station");
        policeStationMap.put("virudhunagar_veppampattu", "Veppampattu Police Station");
        policeStationMap.put("virudhunagar_puliyangudi", "Puliyangudi Police Station");
    }
    
    public static String getPoliceStation(String district, String town) {
        String key = district.toLowerCase() + "_" + town.toLowerCase();
        return policeStationMap.getOrDefault(key, town + " Police Station");
    }
    
    public static void addPoliceLog(String message) {
        String logEntry = "[" + new Date() + "]  POLICE: " + message;
        policeLogs.add(logEntry);
    }
    
    public static void viewPoliceLog() {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("                     POLICE LOG");
        System.out.println("═".repeat(70));
        
        if (policeLogs.isEmpty()) {
            System.out.println("No police logs yet.");
        } else {
            for (String log : policeLogs) {
                System.out.println(log);
            }
        }
        System.out.println("═".repeat(70));
    }
    
    public static void viewAllPoliceStations() {
        System.out.println("\n" + "═".repeat(80));
        System.out.println(" POLICE STATION DATABASE (Total: " + policeStationMap.size() + ")");
        System.out.println("═".repeat(80));
        
        TreeMap<String, String> sorted = new TreeMap<>(policeStationMap);
        String currentDistrict = "";
        int index = 1;
        
        for (Map.Entry<String, String> entry : sorted.entrySet()) {
            String[] parts = entry.getKey().split("_");
            String district = parts[0];
            String town = parts.length > 1 ? parts[1] : "";
            
            if (!district.equals(currentDistrict)) {
                currentDistrict = district;
                System.out.println("\n " + district.toUpperCase() + " DISTRICT:");
            }
            System.out.printf("  %-3d %-25s %s\n", index++, town, entry.getValue());
        }
        System.out.println("═".repeat(80));
    }
    
    public static void viewPoliceStationsByDistrict(String district) {
        System.out.println("\n" + "═".repeat(70));
        System.out.println(" POLICE STATIONS IN " + district.toUpperCase());
        System.out.println("═".repeat(70));
        
        int count = 0;
        for (Map.Entry<String, String> entry : policeStationMap.entrySet()) {
            if (entry.getKey().startsWith(district.toLowerCase() + "_")) {
                count++;
                String[] parts = entry.getKey().split("_");
                String town = parts.length > 1 ? parts[1] : "";
                System.out.printf("  %-3d %-25s %s\n", count, town, entry.getValue());
            }
        }
        if (count == 0) System.out.println("  No police stations found!");
        System.out.println("═".repeat(70));
        System.out.println("  Total: " + count + " police stations");
    }
    
    public static void searchPoliceStation(String searchTerm) {
        System.out.println("\n SEARCHING: " + searchTerm);
        int count = 0;
        for (Map.Entry<String, String> entry : policeStationMap.entrySet()) {
            if (entry.getValue().toLowerCase().contains(searchTerm.toLowerCase())) {
                count++;
                String[] parts = entry.getKey().split("_");
                System.out.printf("  %d. [%s] %s - %s\n", count, 
                    parts[0].toUpperCase(), 
                    parts.length > 1 ? parts[1] : "", 
                    entry.getValue());
            }
        }
        if (count == 0) System.out.println("  No results found!");
    }
    
    public static void addPoliceStation(String district, String town, String stationName) {
        String key = district.toLowerCase() + "_" + town.toLowerCase();
        if (policeStationMap.containsKey(key)) {
            System.out.println(" Police station already exists!");
            return;
        }
        policeStationMap.put(key, stationName);
        addPoliceLog("ADDED: " + stationName + " at " + district + "/" + town);
        saveToFile();
        System.out.println("Police station added successfully!");
    }
    
    public static void updatePoliceStation(String district, String town, String newStationName) {
        String key = district.toLowerCase() + "_" + town.toLowerCase();
        if (policeStationMap.containsKey(key)) {
            String oldName = policeStationMap.get(key);
            policeStationMap.put(key, newStationName);
            addPoliceLog("UPDATED: " + oldName + " → " + newStationName);
            saveToFile();
            System.out.println(" Police station updated successfully!");
        } else {
            System.out.println(" Police station not found!");
        }
    }
    
    public static void deletePoliceStation(String district, String town) {
        String key = district.toLowerCase() + "_" + town.toLowerCase();
        String removed = policeStationMap.remove(key);
        if (removed != null) {
            addPoliceLog("DELETED: " + removed);
            saveToFile();
            System.out.println(" Police station deleted successfully!");
        } else {
            System.out.println(" Police station not found!");
        }
    }
    
    public static void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DATA_FILE))) {
            for (Map.Entry<String, String> entry : policeStationMap.entrySet()) {
                writer.println(entry.getKey() + "|" + entry.getValue());
            }
        } catch (IOException e) {}
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE))) {
            for (String log : policeLogs) {
                writer.println(log);
            }
        } catch (IOException e) {}
    }
    
    public static void loadFromFile() {
        File file = new File(DATA_FILE);
        if (!file.exists()) return;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    policeStationMap.put(parts[0], parts[1]);
                }
            }
            System.out.println(" Loaded " + policeStationMap.size() + " police stations");
        } catch (IOException e) {}
        
        File logFile = new File(LOG_FILE);
        if (logFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    policeLogs.add(line);
                }
            } catch (IOException e) {}
        }
    }
    
    public static int getPoliceStationCount() { return policeStationMap.size(); }
}