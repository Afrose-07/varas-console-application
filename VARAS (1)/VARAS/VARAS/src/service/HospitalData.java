package service;

import java.util.*;
import java.io.*;

public class HospitalData {
    private static Map<String, String> hospitalMap = new HashMap<>();
    private static List<String> hospitalLogs = new ArrayList<>();
    private static final String DATA_FILE = "hospitals.txt";
    private static final String LOG_FILE = "hospital_log.txt";
    
    static {
        // ==================== CHENNAI DISTRICT ====================
        hospitalMap.put("chennai_anna nagar", "Anna Nagar Government Hospital");
        hospitalMap.put("chennai_t.nagar", "T.Nagar Government Hospital");
        hospitalMap.put("chennai_mylapore", "Mylapore Government Hospital");
        hospitalMap.put("chennai_guindy", "Guindy Government Hospital");
        hospitalMap.put("chennai_adyar", "Adyar Government Hospital");
        hospitalMap.put("chennai_ambattur", "Ambattur Government Hospital");
        hospitalMap.put("chennai_perambur", "Perambur Government Hospital");
        hospitalMap.put("chennai_thiruvottiyur", "Thiruvottiyur Government Hospital");
        hospitalMap.put("chennai_velachery", "Velachery Government Hospital");
        hospitalMap.put("chennai_royapuram", "Royapuram Government Hospital");
        hospitalMap.put("chennai_tharamani", "Tharamani Government Hospital");
        hospitalMap.put("chennai_purasawalkam", "Purasawalkam Government Hospital");
        hospitalMap.put("chennai_tambaram", "Tambaram Government Hospital");
        hospitalMap.put("chennai_kodambakkam", "Kodambakkam Government Hospital");
        hospitalMap.put("chennai_vadapalani", "Vadapalani Government Hospital");

        // ==================== ARIYALUR DISTRICT ====================
        hospitalMap.put("ariyalur_ariyalur", "Government Hospital Ariyalur");
        hospitalMap.put("ariyalur_jayankondam", "Government Hospital Jayankondam");
        hospitalMap.put("ariyalur_udukkottai", "Government Hospital Udukkottai");
        hospitalMap.put("ariyalur_sendurai", "Government Hospital Sendurai");
        hospitalMap.put("ariyalur_andimadam", "Government Hospital Andimadam");
        hospitalMap.put("ariyalur_thathanur", "Government Hospital Thathanur");
        hospitalMap.put("ariyalur_veeraganur", "Government Hospital Veeraganur");
        hospitalMap.put("ariyalur_keelapaluvur", "Government Hospital Keelapaluvur");
        hospitalMap.put("ariyalur_thirumanur", "Government Hospital Thirumanur");
        hospitalMap.put("ariyalur_kovilur", "Government Hospital Kovilur");
        hospitalMap.put("ariyalur_elakurichi", "Government Hospital Elakurichi");
        hospitalMap.put("ariyalur_meensurutti", "Government Hospital Meensurutti");
        hospitalMap.put("ariyalur_rayampuram", "Government Hospital Rayampuram");
        hospitalMap.put("ariyalur_thaluthalai", "Government Hospital Thaluthalai");
        hospitalMap.put("ariyalur_kovandakurichi", "Government Hospital Kovandakurichi");

        // ==================== CHENGALPATTU DISTRICT ====================
        hospitalMap.put("chengalpattu_chengalpattu", "Chengalpattu Government Medical College Hospital");
        hospitalMap.put("chengalpattu_maduravoyal", "Maduravoyal Government Hospital");
        hospitalMap.put("chengalpattu_thiruporur", "Thiruporur Government Hospital");
        hospitalMap.put("chengalpattu_chellambakkam", "Chellambakkam Government Hospital");
        hospitalMap.put("chengalpattu_vandalur", "Vandalur Government Hospital");
        hospitalMap.put("chengalpattu_uthiramerur", "Uthiramerur Government Hospital");
        hospitalMap.put("chengalpattu_madurantakam", "Madurantakam Government Hospital");
        hospitalMap.put("chengalpattu_kovalam", "Kovalam Government Hospital");
        hospitalMap.put("chengalpattu_mamallapuram", "Mamallapuram Government Hospital");
        hospitalMap.put("chengalpattu_thirukkazhukundram", "Thirukkazhukundram Government Hospital");
        hospitalMap.put("chengalpattu_pudupattinam", "Pudupattinam Government Hospital");
        hospitalMap.put("chengalpattu_paranur", "Paranur Government Hospital");
        hospitalMap.put("chengalpattu_sunguvarchatram", "Sunguvarchatram Government Hospital");
        hospitalMap.put("chengalpattu_kattankulathur", "Kattankulathur Government Hospital");
        hospitalMap.put("chengalpattu_semmencheri", "Semmencheri Government Hospital");

        // ==================== COIMBATORE DISTRICT ====================
        hospitalMap.put("coimbatore_coimbatore", "Coimbatore Medical College Hospital");
        hospitalMap.put("coimbatore_peelamedu", "Peelamedu Government Hospital");
        hospitalMap.put("coimbatore_singanallur", "Singanallur Government Hospital");
        hospitalMap.put("coimbatore_pollachi", "Pollachi Government Hospital");
        hospitalMap.put("coimbatore_mettupalayam", "Mettupalayam Government Hospital");
        hospitalMap.put("coimbatore_annur", "Annur Government Hospital");
        hospitalMap.put("coimbatore_sulur", "Sulur Government Hospital");
        hospitalMap.put("coimbatore_kinathukadavu", "Kinathukadavu Government Hospital");
        hospitalMap.put("coimbatore_valparai", "Valparai Government Hospital");
        hospitalMap.put("coimbatore_palladam", "Palladam Government Hospital");
        hospitalMap.put("coimbatore_thondamuthur", "Thondamuthur Government Hospital");
        hospitalMap.put("coimbatore_madukkarai", "Madukkarai Government Hospital");
        hospitalMap.put("coimbatore_perur", "Perur Government Hospital");
        hospitalMap.put("coimbatore_kuniyamuthur", "Kuniyamuthur Government Hospital");
        hospitalMap.put("coimbatore_saravanampatti", "Saravanampatti Government Hospital");

        // ==================== CUDDALORE DISTRICT ====================
        hospitalMap.put("cuddalore_cuddalore", "Government Hospital Cuddalore");
        hospitalMap.put("cuddalore_chidambaram", "Chidambaram Government Hospital");
        hospitalMap.put("cuddalore_vriddhachalam", "Vriddhachalam Government Hospital");
        hospitalMap.put("cuddalore_panruti", "Panruti Government Hospital");
        hospitalMap.put("cuddalore_kurinjipadi", "Kurinjipadi Government Hospital");
        hospitalMap.put("cuddalore_veeranam", "Veeranam Government Hospital");
        hospitalMap.put("cuddalore_kattumannarkoil", "Kattumannarkoil Government Hospital");
        hospitalMap.put("cuddalore_srimushnam", "Srimushnam Government Hospital");
        hospitalMap.put("cuddalore_tittagudi", "Tittagudi Government Hospital");
        hospitalMap.put("cuddalore_parangipettai", "Parangipettai Government Hospital");
        hospitalMap.put("cuddalore_bhuvanagiri", "Bhuvanagiri Government Hospital");
        hospitalMap.put("cuddalore_sethiathope", "Sethiathope Government Hospital");
        hospitalMap.put("cuddalore_mangalampet", "Mangalampet Government Hospital");
        hospitalMap.put("cuddalore_nellikuppam", "Nellikuppam Government Hospital");
        hospitalMap.put("cuddalore_keerapalayam", "Keerapalayam Government Hospital");

        // ==================== DHARMAPURI DISTRICT ====================
        hospitalMap.put("dharmapuri_dharmapuri", "Dharmapuri Government Medical College Hospital");
        hospitalMap.put("dharmapuri_harur", "Harur Government Hospital");
        hospitalMap.put("dharmapuri_palacode", "Palacode Government Hospital");
        hospitalMap.put("dharmapuri_marandahalli", "Marandahalli Government Hospital");
        hospitalMap.put("dharmapuri_kadathur", "Kadathur Government Hospital");
        hospitalMap.put("dharmapuri_karimangalam", "Karimangalam Government Hospital");
        hospitalMap.put("dharmapuri_morappur", "Morappur Government Hospital");
        hospitalMap.put("dharmapuri_pappireddipatti", "Pappireddipatti Government Hospital");
        hospitalMap.put("dharmapuri_nerippanur", "Nerippanur Government Hospital");
        hospitalMap.put("dharmapuri_bommidi", "Bommidi Government Hospital");
        hospitalMap.put("dharmapuri_thoppur", "Thoppur Government Hospital");
        hospitalMap.put("dharmapuri_eriyur", "Eriyur Government Hospital");
        hospitalMap.put("dharmapuri_indur", "Indur Government Hospital");
        hospitalMap.put("dharmapuri_mulagumudu", "Mulagumudu Government Hospital");
        hospitalMap.put("dharmapuri_sivadi", "Sivadi Government Hospital");

        // ==================== DINDIGUL DISTRICT ====================
        hospitalMap.put("dindigul_dindigul", "Government Dindigul Medical College Hospital");
        hospitalMap.put("dindigul_kodaikanal", "Kodaikanal Government Hospital");
        hospitalMap.put("dindigul_palani", "Palani Government Hospital");
        hospitalMap.put("dindigul_vedasandur", "Vedasandur Government Hospital");
        hospitalMap.put("dindigul_natham", "Natham Government Hospital");
        hospitalMap.put("dindigul_nilakottai", "Nilakottai Government Hospital");
        hospitalMap.put("dindigul_oddanchatram", "Oddanchatram Government Hospital");
        hospitalMap.put("dindigul_ayyalur", "Ayyalur Government Hospital");
        hospitalMap.put("dindigul_vadamadurai", "Vadamadurai Government Hospital");
        hospitalMap.put("dindigul_guziliamparai", "Guziliamparai Government Hospital");
        hospitalMap.put("dindigul_ambathurai", "Ambathurai Government Hospital");
        hospitalMap.put("dindigul_sanarpatti", "Sanarpatti Government Hospital");
        hospitalMap.put("dindigul_thoppampatti", "Thoppampatti Government Hospital");
        hospitalMap.put("dindigul_vattalkundu", "Vattalkundu Government Hospital");
        hospitalMap.put("dindigul_kanavaipatti", "Kanavaipatti Government Hospital");

        // ==================== ERODE DISTRICT ====================
        hospitalMap.put("erode_erode", "Government Erode Medical College Hospital");
        hospitalMap.put("erode_gobichettipalayam", "Gobichettipalayam Government Hospital");
        hospitalMap.put("erode_sathyamangalam", "Sathyamangalam Government Hospital");
        hospitalMap.put("erode_bhavani", "Bhavani Government Hospital");
        hospitalMap.put("erode_perundurai", "Perundurai Government Hospital");
        hospitalMap.put("erode_kodumudi", "Kodumudi Government Hospital");
        hospitalMap.put("erode_anthiyur", "Anthiyur Government Hospital");
        hospitalMap.put("erode_modakurichi", "Modakurichi Government Hospital");
        hospitalMap.put("erode_kavandapadi", "Kavandapadi Government Hospital");
        hospitalMap.put("erode_nambiyur", "Nambiyur Government Hospital");
        hospitalMap.put("erode_thalavadi", "Thalavadi Government Hospital");
        hospitalMap.put("erode_punjai puliyampatti", "Punjai Puliyampatti Government Hospital");
        hospitalMap.put("erode_ammapet", "Ammapet Government Hospital");
        hospitalMap.put("erode_chithode", "Chithode Government Hospital");
        hospitalMap.put("erode_surampatti", "Surampatti Government Hospital");

        // ==================== KALLAKURICHI DISTRICT ====================
        hospitalMap.put("kallakurichi_kallakurichi", "Government Hospital Kallakurichi");
        hospitalMap.put("kallakurichi_tirukoilur", "Tirukoilur Government Hospital");
        hospitalMap.put("kallakurichi_sankarapuram", "Sankarapuram Government Hospital");
        hospitalMap.put("kallakurichi_ulundurpet", "Ulundurpet Government Hospital");
        hospitalMap.put("kallakurichi_chinnasalem", "Chinnasalem Government Hospital");
        hospitalMap.put("kallakurichi_kalvarayan hills", "Kalvarayan Hills Government Hospital");
        hospitalMap.put("kallakurichi_soorapattu", "Soorapattu Government Hospital");
        hospitalMap.put("kallakurichi_rastampettai", "Rastampettai Government Hospital");
        hospitalMap.put("kallakurichi_melur", "Melur Government Hospital");
        hospitalMap.put("kallakurichi_thirunavalur", "Thirunavalur Government Hospital");
        hospitalMap.put("kallakurichi_manalurpet", "Manalurpet Government Hospital");
        hospitalMap.put("kallakurichi_therani", "Therani Government Hospital");
        hospitalMap.put("kallakurichi_mugaiyur", "Mugaiyur Government Hospital");
        hospitalMap.put("kallakurichi_thiagadurgam", "Thiagadurgam Government Hospital");
        hospitalMap.put("kallakurichi_kachirampalayam", "Kachirampalayam Government Hospital");

        // ==================== KANCHIPURAM DISTRICT ====================
        hospitalMap.put("kancheepuram_kancheepuram", "Government Hospital Kancheepuram");
        hospitalMap.put("kancheepuram_sriperumbudur", "Sriperumbudur Government Hospital");
        hospitalMap.put("kancheepuram_uthiramerur", "Uthiramerur Government Hospital");
        hospitalMap.put("kancheepuram_kundrathur", "Kundrathur Government Hospital");
        hospitalMap.put("kancheepuram_mangadu", "Mangadu Government Hospital");
        hospitalMap.put("kancheepuram_poonamallee", "Poonamallee Government Hospital");
        hospitalMap.put("kancheepuram_walajabad", "Walajabad Government Hospital");
        hospitalMap.put("kancheepuram_sevilimedu", "Sevilimedu Government Hospital");
        hospitalMap.put("kancheepuram_orkkadam", "Orkkadam Government Hospital");
        hospitalMap.put("kancheepuram_manimangalam", "Manimangalam Government Hospital");
        hospitalMap.put("kancheepuram_sunguvarchatram", "Sunguvarchatram Government Hospital");
        hospitalMap.put("kancheepuram_thiruporur", "Thiruporur Government Hospital");
        hospitalMap.put("kancheepuram_cheyyur", "Cheyyur Government Hospital");
        hospitalMap.put("kancheepuram_madurantakam", "Madurantakam Government Hospital");
        hospitalMap.put("kancheepuram_karunguzhi", "Karunguzhi Government Hospital");

        // ==================== KANYAKUMARI DISTRICT ====================
        hospitalMap.put("kanyakumari_nagercoil", "Kanyakumari Government Medical College Hospital");
        hospitalMap.put("kanyakumari_kanyakumari", "Kanyakumari Government Hospital");
        hospitalMap.put("kanyakumari_marthandam", "Marthandam Government Hospital");
        hospitalMap.put("kanyakumari_kuzhithurai", "Kuzhithurai Government Hospital");
        hospitalMap.put("kanyakumari_padmanabhapuram", "Padmanabhapuram Government Hospital");
        hospitalMap.put("kanyakumari_thuckalay", "Thuckalay Government Hospital");
        hospitalMap.put("kanyakumari_kollencode", "Kollencode Government Hospital");
        hospitalMap.put("kanyakumari_karungal", "Karungal Government Hospital");
        hospitalMap.put("kanyakumari_killiyur", "Killiyur Government Hospital");
        hospitalMap.put("kanyakumari_rajakkamangalam", "Rajakkamangalam Government Hospital");
        hospitalMap.put("kanyakumari_kurunthencode", "Kurunthencode Government Hospital");
        hospitalMap.put("kanyakumari_puthalam", "Puthalam Government Hospital");
        hospitalMap.put("kanyakumari_eraviputhenthurai", "Eraviputhenthurai Government Hospital");
        hospitalMap.put("kanyakumari_midalam", "Midalam Government Hospital");
        hospitalMap.put("kanyakumari_pechipparai", "Pechipparai Government Hospital");

        // ==================== KARUR DISTRICT ====================
        hospitalMap.put("karur_karur", "Karur Government Medical College Hospital");
        hospitalMap.put("karur_kulithalai", "Kulithalai Government Hospital");
        hospitalMap.put("karur_thogamalai", "Thogamalai Government Hospital");
        hospitalMap.put("karur_aravakurichi", "Aravakurichi Government Hospital");
        hospitalMap.put("karur_pallapatti", "Pallapatti Government Hospital");
        hospitalMap.put("karur_krishnarayapuram", "Krishnarayapuram Government Hospital");
        hospitalMap.put("karur_kadavur", "Kadavur Government Hospital");
        hospitalMap.put("karur_vangal", "Vangal Government Hospital");
        hospitalMap.put("karur_inungalur", "Inungalur Government Hospital");
        hospitalMap.put("karur_thanthoni", "Thanthoni Government Hospital");
        hospitalMap.put("karur_puliyur", "Puliyur Government Hospital");
        hospitalMap.put("karur_nerur", "Nerur Government Hospital");
        hospitalMap.put("karur_velayuthampalayam", "Velayuthampalayam Government Hospital");
        hospitalMap.put("karur_mayanur", "Mayanur Government Hospital");
        hospitalMap.put("karur_k.pudupatti", "K.Pudupatti Government Hospital");

        // ==================== KRISHNAGIRI DISTRICT ====================
        hospitalMap.put("krishnagiri_krishnagiri", "Krishnagiri Government Hospital");
        hospitalMap.put("krishnagiri_hosur", "Hosur Government Hospital");
        hospitalMap.put("krishnagiri_denkanikottai", "Denkanikottai Government Hospital");
        hospitalMap.put("krishnagiri_pochampalli", "Pochampalli Government Hospital");
        hospitalMap.put("krishnagiri_uthangarai", "Uthangarai Government Hospital");
        hospitalMap.put("krishnagiri_shoolagiri", "Shoolagiri Government Hospital");
        hospitalMap.put("krishnagiri_bargur", "Bargur Government Hospital");
        hospitalMap.put("krishnagiri_kaveripattinam", "Kaveripattinam Government Hospital");
        hospitalMap.put("krishnagiri_veppanapalli", "Veppanapalli Government Hospital");
        hospitalMap.put("krishnagiri_mathur", "Mathur Government Hospital");
        hospitalMap.put("krishnagiri_kelamangalam", "Kelamangalam Government Hospital");
        hospitalMap.put("krishnagiri_thally", "Thally Government Hospital");
        hospitalMap.put("krishnagiri_samalpatti", "Samalpatti Government Hospital");
        hospitalMap.put("krishnagiri_nerkundram", "Nerkundram Government Hospital");
        hospitalMap.put("krishnagiri_mookandapalli", "Mookandapalli Government Hospital");

        // ==================== MADURAI DISTRICT ====================
        hospitalMap.put("madurai_madurai", "Government Rajaji Hospital");
        hospitalMap.put("madurai_thirumangalam", "Thirumangalam Government Hospital");
        hospitalMap.put("madurai_usilampatti", "Usilampatti Government Hospital");
        hospitalMap.put("madurai_melur", "Melur Government Hospital");
        hospitalMap.put("madurai_vadipatti", "Vadipatti Government Hospital");
        hospitalMap.put("madurai_sholavandan", "Sholavandan Government Hospital");
        hospitalMap.put("madurai_peraiyur", "Peraiyur Government Hospital");
        hospitalMap.put("madurai_kallikudi", "Kallikudi Government Hospital");
        hospitalMap.put("madurai_thirupparankundram", "Thirupparankundram Government Hospital");
        hospitalMap.put("madurai_alanganallur", "Alanganallur Government Hospital");
        hospitalMap.put("madurai_t.kallupatti", "T.Kallupatti Government Hospital");
        hospitalMap.put("madurai_sedapatti", "Sedapatti Government Hospital");
        hospitalMap.put("madurai_kottampatti", "Kottampatti Government Hospital");
        hospitalMap.put("madurai_chellampatti", "Chellampatti Government Hospital");
        hospitalMap.put("madurai_mangulam", "Mangulam Government Hospital");

        // ==================== MAYILADUTHURAI DISTRICT ====================
        hospitalMap.put("mayiladuthurai_mayiladuthurai", "Government Hospital Mayiladuthurai");
        hospitalMap.put("mayiladuthurai_sirkazhi", "Sirkazhi Government Hospital");
        hospitalMap.put("mayiladuthurai_manampathy", "Manampathy Government Hospital");
        hospitalMap.put("mayiladuthurai_poonthottam", "Poonthottam Government Hospital");
        hospitalMap.put("mayiladuthurai_kuthalam", "Kuthalam Government Hospital");
        hospitalMap.put("mayiladuthurai_sembanarkoil", "Sembanarkoil Government Hospital");
        hospitalMap.put("mayiladuthurai_tharangambadi", "Tharangambadi Government Hospital");
        hospitalMap.put("mayiladuthurai_kozhikudi", "Kozhikudi Government Hospital");
        hospitalMap.put("mayiladuthurai_manalmedu", "Manalmedu Government Hospital");
        hospitalMap.put("mayiladuthurai_korukkai", "Korukkai Government Hospital");
        hospitalMap.put("mayiladuthurai_mangaimadam", "Mangaimadam Government Hospital");
        hospitalMap.put("mayiladuthurai_muttam", "Muttam Government Hospital");
        hospitalMap.put("mayiladuthurai_thiruvengadu", "Thiruvengadu Government Hospital");
        hospitalMap.put("mayiladuthurai_keezhaiyur", "Keezhaiyur Government Hospital");
        hospitalMap.put("mayiladuthurai_vazhkai", "Vazhkai Government Hospital");

        // ==================== NAGAPATTINAM DISTRICT ====================
        hospitalMap.put("nagapattinam_nagapattinam", "Government Hospital Nagapattinam");
        hospitalMap.put("nagapattinam_vedaranyam", "Vedaranyam Government Hospital");
        hospitalMap.put("nagapattinam_thiruvarur", "Thiruvarur Government Hospital");
        hospitalMap.put("nagapattinam_mannargudi", "Mannargudi Government Hospital");
        hospitalMap.put("nagapattinam_nannilam", "Nannilam Government Hospital");
        hospitalMap.put("nagapattinam_kilvelur", "Kilvelur Government Hospital");
        hospitalMap.put("nagapattinam_thalainayar", "Thalainayar Government Hospital");
        hospitalMap.put("nagapattinam_kechankuppam", "Kechankuppam Government Hospital");
        hospitalMap.put("nagapattinam_akkaraipettai", "Akkaraipettai Government Hospital");
        hospitalMap.put("nagapattinam_porayar", "Porayar Government Hospital");
        hospitalMap.put("nagapattinam_kodikarai", "Kodikarai Government Hospital");
        hospitalMap.put("nagapattinam_thirumarugal", "Thirumarugal Government Hospital");
        hospitalMap.put("nagapattinam_ettukudi", "Ettukudi Government Hospital");
        hospitalMap.put("nagapattinam_velankanni", "Velankanni Government Hospital");
        hospitalMap.put("nagapattinam_nagakudi", "Nagakudi Government Hospital");

        // ==================== NAMAKKAL DISTRICT ====================
        hospitalMap.put("namakkal_namakkal", "Namakkal Government Hospital");
        hospitalMap.put("namakkal_tiruchengode", "Tiruchengode Government Hospital");
        hospitalMap.put("namakkal_rasipuram", "Rasipuram Government Hospital");
        hospitalMap.put("namakkal_kumarapalayam", "Kumarapalayam Government Hospital");
        hospitalMap.put("namakkal_paramathi", "Paramathi Government Hospital");
        hospitalMap.put("namakkal_sendamangalam", "Sendamangalam Government Hospital");
        hospitalMap.put("namakkal_mohanur", "Mohanur Government Hospital");
        hospitalMap.put("namakkal_namagiripettai", "Namagiripettai Government Hospital");
        hospitalMap.put("namakkal_erumapatti", "Erumapatti Government Hospital");
        hospitalMap.put("namakkal_pallipalayam", "Pallipalayam Government Hospital");
        hospitalMap.put("namakkal_komarapalayam", "Komarapalayam Government Hospital");
        hospitalMap.put("namakkal_vazhapadi", "Vazhapadi Government Hospital");
        hospitalMap.put("namakkal_kabilarmalai", "Kabilarmalai Government Hospital");
        hospitalMap.put("namakkal_mallasamudram", "Mallasamudram Government Hospital");
        hospitalMap.put("namakkal_venandur", "Venandur Government Hospital");

        // ==================== NILGIRIS DISTRICT ====================
        hospitalMap.put("nilgiris_ooty", "Government Medical College Hospital Ooty");
        hospitalMap.put("nilgiris_koonoor", "Koonoor Government Hospital");
        hospitalMap.put("nilgiris_gudalur", "Gudalur Government Hospital");
        hospitalMap.put("nilgiris_kotagiri", "Kotagiri Government Hospital");
        hospitalMap.put("nilgiris_coonoor", "Coonoor Government Hospital");
        hospitalMap.put("nilgiris_wellington", "Wellington Government Hospital");
        hospitalMap.put("nilgiris_adanakatti", "Adanakatti Government Hospital");
        hospitalMap.put("nilgiris_manjoor", "Manjoor Government Hospital");
        hospitalMap.put("nilgiris_kethi", "Kethi Government Hospital");
        hospitalMap.put("nilgiris_hubbathalai", "Hubbathalai Government Hospital");
        hospitalMap.put("nilgiris_denad", "Denad Government Hospital");
        hospitalMap.put("nilgiris_kagguchi", "Kagguchi Government Hospital");
        hospitalMap.put("nilgiris_erumad", "Erumad Government Hospital");
        hospitalMap.put("nilgiris_thalayathimund", "Thalayathimund Government Hospital");
        hospitalMap.put("nilgiris_parlikal", "Parlikal Government Hospital");

        // ==================== PERAMBALUR DISTRICT ====================
        hospitalMap.put("perambalur_perambalur", "Government Hospital Perambalur");
        hospitalMap.put("perambalur_veeraganur", "Veeraganur Government Hospital");
        hospitalMap.put("perambalur_kunnam", "Kunnam Government Hospital");
        hospitalMap.put("perambalur_alathur", "Alathur Government Hospital");
        hospitalMap.put("perambalur_aranarai", "Aranarai Government Hospital");
        hospitalMap.put("perambalur_esanai", "Esanai Government Hospital");
        hospitalMap.put("perambalur_kurumbalur", "Kurumbalur Government Hospital");
        hospitalMap.put("perambalur_ladapuram", "Ladapuram Government Hospital");
        hospitalMap.put("perambalur_venbavur", "Venbavur Government Hospital");
        hospitalMap.put("perambalur_murukkambadi", "Murukkambadi Government Hospital");
        hospitalMap.put("perambalur_keelapuliyur", "Keelapuliyur Government Hospital");
        hospitalMap.put("perambalur_olakkur", "Olakkur Government Hospital");
        hospitalMap.put("perambalur_paravai", "Paravai Government Hospital");
        hospitalMap.put("perambalur_thirumanur", "Thirumanur Government Hospital");
        hospitalMap.put("perambalur_mangalamedu", "Mangalamedu Government Hospital");

        // ==================== PUDUKKOTTAI DISTRICT ====================
        hospitalMap.put("pudukkottai_pudukkottai", "Government Medical College Hospital Pudukkottai");
        hospitalMap.put("pudukkottai_aranthangi", "Aranthangi Government Hospital");
        hospitalMap.put("pudukkottai_karambakudi", "Karambakudi Government Hospital");
        hospitalMap.put("pudukkottai_keeramangalam", "Keeramangalam Government Hospital");
        hospitalMap.put("pudukkottai_ponnamaravathy", "Ponnamaravathy Government Hospital");
        hospitalMap.put("pudukkottai_thirumayam", "Thirumayam Government Hospital");
        hospitalMap.put("pudukkottai_iluppur", "Iluppur Government Hospital");
        hospitalMap.put("pudukkottai_avudayarkoil", "Avudayarkoil Government Hospital");
        hospitalMap.put("pudukkottai_kulathur", "Kulathur Government Hospital");
        hospitalMap.put("pudukkottai_gandarvakottai", "Gandarvakottai Government Hospital");
        hospitalMap.put("pudukkottai_manamelkudi", "Manamelkudi Government Hospital");
        hospitalMap.put("pudukkottai_minnathur", "Minnathur Government Hospital");
        hospitalMap.put("pudukkottai_annanagar", "Annanagar Government Hospital");
        hospitalMap.put("pudukkottai_viralimalai", "Viralimalai Government Hospital");
        hospitalMap.put("pudukkottai_kundrandarkoil", "Kundrandarkoil Government Hospital");

        // ==================== RAMANATHAPURAM DISTRICT ====================
        hospitalMap.put("ramanathapuram_ramanathapuram", "Government Hospital Ramanathapuram");
        hospitalMap.put("ramanathapuram_paramakudi", "Paramakudi Government Hospital");
        hospitalMap.put("ramanathapuram_keelakarai", "Keelakarai Government Hospital");
        hospitalMap.put("ramanathapuram_rameshwaram", "Rameshwaram Government Hospital");
        hospitalMap.put("ramanathapuram_mudukulathur", "Mudukulathur Government Hospital");
        hospitalMap.put("ramanathapuram_kamuthi", "Kamuthi Government Hospital");
        hospitalMap.put("ramanathapuram_thiruvadanai", "Thiruvadanai Government Hospital");
        hospitalMap.put("ramanathapuram_rajasingamangalam", "Rajasingamangalam Government Hospital");
        hospitalMap.put("ramanathapuram_sayalkudi", "Sayalkudi Government Hospital");
        hospitalMap.put("ramanathapuram_erwadi", "Erwadi Government Hospital");
        hospitalMap.put("ramanathapuram_thalavoor", "Thalavoor Government Hospital");
        hospitalMap.put("ramanathapuram_avaniam", "Avaniam Government Hospital");
        hospitalMap.put("ramanathapuram_bogalur", "Bogalur Government Hospital");
        hospitalMap.put("ramanathapuram_narippaiyur", "Narippaiyur Government Hospital");
        hospitalMap.put("ramanathapuram_vedhalai", "Vedhalai Government Hospital");

        // ==================== RANIPET DISTRICT ====================
        hospitalMap.put("ranipet_ranipet", "Government Hospital Ranipet");
        hospitalMap.put("ranipet_arcot", "Arcot Government Hospital");
        hospitalMap.put("ranipet_walajapet", "Walajapet Government Hospital");
        hospitalMap.put("ranipet_ambur", "Ambur Government Hospital");
        hospitalMap.put("ranipet_vaniyambadi", "Vaniyambadi Government Hospital");
        hospitalMap.put("ranipet_nemili", "Nemili Government Hospital");
        hospitalMap.put("ranipet_timiri", "Timiri Government Hospital");
        hospitalMap.put("ranipet_a.kondur", "A.Kondur Government Hospital");
        hospitalMap.put("ranipet_melvisharam", "Melvisharam Government Hospital");
        hospitalMap.put("ranipet_sholingur", "Sholingur Government Hospital");
        hospitalMap.put("ranipet_banavaram", "Banavaram Government Hospital");
        hospitalMap.put("ranipet_kalavai", "Kalavai Government Hospital");
        hospitalMap.put("ranipet_thiruvalam", "Thiruvalam Government Hospital");
        hospitalMap.put("ranipet_mullipattu", "Mullipattu Government Hospital");
        hospitalMap.put("ranipet_kannamangalam", "Kannamangalam Government Hospital");

        // ==================== SALEM DISTRICT ====================
        hospitalMap.put("salem_salem", "Government Mohan Kumaramangalam Hospital");
        hospitalMap.put("salem_attur", "Attur Government Hospital");
        hospitalMap.put("salem_mettur", "Mettur Government Hospital");
        hospitalMap.put("salem_sankagiri", "Sankagiri Government Hospital");
        hospitalMap.put("salem_edappadi", "Edappadi Government Hospital");
        hospitalMap.put("salem_ompalayam", "Ompalayam Government Hospital");
        hospitalMap.put("salem_tharamangalam", "Tharamangalam Government Hospital");
        hospitalMap.put("salem_kondalampatti", "Kondalampatti Government Hospital");
        hospitalMap.put("salem_veerapandi", "Veerapandi Government Hospital");
        hospitalMap.put("salem_ayothiyapattinam", "Ayothiyapattinam Government Hospital");
        hospitalMap.put("salem_thalavasai", "Thalavasai Government Hospital");
        hospitalMap.put("salem_poolampatti", "Poolampatti Government Hospital");
        hospitalMap.put("salem_karumandurai", "Karumandurai Government Hospital");
        hospitalMap.put("salem_kadayampatti", "Kadayampatti Government Hospital");
        hospitalMap.put("salem_vazhapadi", "Vazhapadi Government Hospital");

        // ==================== SIVAGANGAI DISTRICT ====================
        hospitalMap.put("sivagangai_sivagangai", "Sivagangai Medical College Hospital");
        hospitalMap.put("sivagangai_karaikudi", "Karaikudi Government Hospital");
        hospitalMap.put("sivagangai_devakottai", "Devakottai Government Hospital");
        hospitalMap.put("sivagangai_manamadurai", "Manamadurai Government Hospital");
        hospitalMap.put("sivagangai_ilayangudi", "Ilayangudi Government Hospital");
        hospitalMap.put("sivagangai_thirupathur", "Thirupathur Government Hospital");
        hospitalMap.put("sivagangai_kallal", "Kallal Government Hospital");
        hospitalMap.put("sivagangai_singampunari", "Singampunari Government Hospital");
        hospitalMap.put("sivagangai_kalayarkoil", "Kalayarkoil Government Hospital");
        hospitalMap.put("sivagangai_kandanur", "Kandanur Government Hospital");
        hospitalMap.put("sivagangai_sakkottai", "Sakkottai Government Hospital");
        hospitalMap.put("sivagangai_puduvayal", "Puduvayal Government Hospital");
        hospitalMap.put("sivagangai_nattarasankottai", "Nattarasankottai Government Hospital");
        hospitalMap.put("sivagangai_kottaiyur", "Kottaiyur Government Hospital");
        hospitalMap.put("sivagangai_thirukostiyur", "Thirukostiyur Government Hospital");

        // ==================== TENKASI DISTRICT ====================
        hospitalMap.put("tenkasi_tenkasi", "Government Hospital Tenkasi");
        hospitalMap.put("tenkasi_sankarankovil", "Sankarankovil Government Hospital");
        hospitalMap.put("tenkasi_kadayanallur", "Kadayanallur Government Hospital");
        hospitalMap.put("tenkasi_shenkottai", "Shenkottai Government Hospital");
        hospitalMap.put("tenkasi_puliyangudi", "Puliyangudi Government Hospital");
        hospitalMap.put("tenkasi_veerakeralampudur", "Veerakeralampudur Government Hospital");
        hospitalMap.put("tenkasi_ilaiyangudi", "Ilaiyangudi Government Hospital");
        hospitalMap.put("tenkasi_keelapavoor", "Keelapavoor Government Hospital");
        hospitalMap.put("tenkasi_kuruvikulam", "Kuruvikulam Government Hospital");
        hospitalMap.put("tenkasi_melagaram", "Melagaram Government Hospital");
        hospitalMap.put("tenkasi_ayikudi", "Ayikudi Government Hospital");
        hospitalMap.put("tenkasi_sundarapandiapuram", "Sundarapandiapuram Government Hospital");
        hospitalMap.put("tenkasi_thalmai", "Thalmai Government Hospital");
        hospitalMap.put("tenkasi_panpozhi", "Panpozhi Government Hospital");
        hospitalMap.put("tenkasi_sivagiri", "Sivagiri Government Hospital");

        // ==================== THANJAVUR DISTRICT ====================
        hospitalMap.put("thanjavur_thanjavur", "Thanjavur Medical College Hospital");
        hospitalMap.put("thanjavur_kumbakonam", "Kumbakonam Government Hospital");
        hospitalMap.put("thanjavur_pattukkottai", "Pattukkottai Government Hospital");
        hospitalMap.put("thanjavur_needamangalam", "Needamangalam Government Hospital");
        hospitalMap.put("thanjavur_thirukattupalli", "Thirukattupalli Government Hospital");
        hospitalMap.put("thanjavur_ammapettai", "Ammapettai Government Hospital");
        hospitalMap.put("thanjavur_papanasam", "Papanasam Government Hospital");
        hospitalMap.put("thanjavur_thiruvaiyaru", "Thiruvaiyaru Government Hospital");
        hospitalMap.put("thanjavur_orangallur", "Orangallur Government Hospital");
        hospitalMap.put("thanjavur_vallam", "Vallam Government Hospital");
        hospitalMap.put("thanjavur_adanur", "Adanur Government Hospital");
        hospitalMap.put("thanjavur_budalur", "Budalur Government Hospital");
        hospitalMap.put("thanjavur_thiruppanandal", "Thiruppanandal Government Hospital");
        hospitalMap.put("thanjavur_madukkur", "Madukkur Government Hospital");
        hospitalMap.put("thanjavur_sethubhavachatram", "Sethubhavachatram Government Hospital");

        // ==================== THENI DISTRICT ====================
        hospitalMap.put("theni_theni", "Theni Government Medical College Hospital");
        hospitalMap.put("theni_periyakulam", "Periyakulam Government Hospital");
        hospitalMap.put("theni_cumbum", "Cumbum Government Hospital");
        hospitalMap.put("theni_gudalur", "Gudalur Government Hospital");
        hospitalMap.put("theni_chinnamanur", "Chinnamanur Government Hospital");
        hospitalMap.put("theni_andalipuram", "Andalipuram Government Hospital");
        hospitalMap.put("theni_kambam", "Kambam Government Hospital");
        hospitalMap.put("theni_myladumparai", "Myladumparai Government Hospital");
        hospitalMap.put("theni_kaniyar", "Kaniyar Government Hospital");
        hospitalMap.put("theni_kuchanur", "Kuchanur Government Hospital");
        hospitalMap.put("theni_vegapandi", "Vegapandi Government Hospital");
        hospitalMap.put("theni_bodinayakanur", "Bodinayakanur Government Hospital");
        hospitalMap.put("theni_uthamapalayam", "Uthamapalayam Government Hospital");
        hospitalMap.put("theni_teekkar", "Teekkar Government Hospital");
        hospitalMap.put("theni_oddanchatram", "Oddanchatram Government Hospital");

        // ==================== THOOTHUKUDI DISTRICT ====================
        hospitalMap.put("thoothukudi_thoothukudi", "Thoothukudi Medical College Hospital");
        hospitalMap.put("thoothukudi_kayalpattinam", "Kayalpattinam Government Hospital");
        hospitalMap.put("thoothukudi_kovilpatti", "Kovilpatti Government Hospital");
        hospitalMap.put("thoothukudi_oththapidaram", "Oththapidaram Government Hospital");
        hospitalMap.put("thoothukudi_ettayapuram", "Ettayapuram Government Hospital");
        hospitalMap.put("thoothukudi_vilathikulam", "Vilathikulam Government Hospital");
        hospitalMap.put("thoothukudi_ottapidaram", "Ottapidaram Government Hospital");
        hospitalMap.put("thoothukudi_sathankulam", "Sathankulam Government Hospital");
        hospitalMap.put("thoothukudi_srivaikuntam", "Srivaikuntam Government Hospital");
        hospitalMap.put("thoothukudi_alwarthirunagari", "Alwarthirunagari Government Hospital");
        hospitalMap.put("thoothukudi_nazerath", "Nazerath Government Hospital");
        hospitalMap.put("thoothukudi_pudur", "Pudur Government Hospital");
        hospitalMap.put("thoothukudi_karungulam", "Karungulam Government Hospital");
        hospitalMap.put("thoothukudi_uthukuli", "Uthukuli Government Hospital");
        hospitalMap.put("thoothukudi_aranthangi", "Aranthangi Government Hospital");

        // ==================== TIRUCHIRAPPALLI DISTRICT ====================
        hospitalMap.put("trichy_tiruchirappalli", "Mahatma Gandhi Memorial Hospital Trichy");
        hospitalMap.put("trichy_srirangam", "Srirangam Government Hospital");
        hospitalMap.put("trichy_thillai nagar", "Thillai Nagar Government Hospital");
        hospitalMap.put("trichy_cantonment", "Cantonment Government Hospital");
        hospitalMap.put("trichy_ponmalai", "Ponmalai Government Hospital");
        hospitalMap.put("trichy_golden rock", "Golden Rock Government Hospital");
        hospitalMap.put("trichy_edamalaipatti", "Edamalaipatti Government Hospital");
        hospitalMap.put("trichy_k.k.nagar", "K.K.Nagar Government Hospital");
        hospitalMap.put("trichy_uthamar gandhi", "Uthamar Gandhi Government Hospital");
        hospitalMap.put("trichy_manachanallur", "Manachanallur Government Hospital");
        hospitalMap.put("trichy_lalgudi", "Lalgudi Government Hospital");
        hospitalMap.put("trichy_thuvakudi", "Thuvakudi Government Hospital");
        hospitalMap.put("trichy_samayapuram", "Samayapuram Government Hospital");
        hospitalMap.put("trichy_musiri", "Musiri Government Hospital");
        hospitalMap.put("trichy_manapparai", "Manapparai Government Hospital");
        hospitalMap.put("trichy_thottiyam", "Thottiyam Government Hospital");

        // ==================== TIRUNELVELI DISTRICT ====================
        hospitalMap.put("tirunelveli_tirunelveli", "Tirunelveli Medical College Hospital");
        hospitalMap.put("tirunelveli_palayamkottai", "Palayamkottai Government Hospital");
        hospitalMap.put("tirunelveli_melapalayam", "Melapalayam Government Hospital");
        hospitalMap.put("tirunelveli_thachanallur", "Thachanallur Government Hospital");
        hospitalMap.put("tirunelveli_pettai", "Pettai Government Hospital");
        hospitalMap.put("tirunelveli_kokkirakulam", "Kokkirakulam Government Hospital");
        hospitalMap.put("tirunelveli_ambasamudram", "Ambasamudram Government Hospital");
        hospitalMap.put("tirunelveli_vikramasingapuram", "Vikramasingapuram Government Hospital");
        hospitalMap.put("tirunelveli_kallidaikurichi", "Kallidaikurichi Government Hospital");
        hospitalMap.put("tirunelveli_cheranmahadevi", "Cheranmahadevi Government Hospital");
        hospitalMap.put("tirunelveli_thisayanvilai", "Thisayanvilai Government Hospital");
        hospitalMap.put("tirunelveli_nanguneri", "Nanguneri Government Hospital");
        hospitalMap.put("tirunelveli_radhapuram", "Radhapuram Government Hospital");
        hospitalMap.put("tirunelveli_sankarankovil", "Sankarankovil Government Hospital");
        hospitalMap.put("tirunelveli_tenkasi", "Tenkasi Government Hospital");
        hospitalMap.put("tirunelveli_shenkottai", "Shenkottai Government Hospital");

        // ==================== TIRUPATHUR DISTRICT ====================
        hospitalMap.put("tirupathur_tirupathur", "Government Hospital Tirupathur");
        hospitalMap.put("tirupathur_vaniyambadi", "Vaniyambadi Government Hospital");
        hospitalMap.put("tirupathur_ambur", "Ambur Government Hospital");
        hospitalMap.put("tirupathur_natrampalli", "Natrampalli Government Hospital");
        hospitalMap.put("tirupathur_jolarpettai", "Jolarpettai Government Hospital");
        hospitalMap.put("tirupathur_kandili", "Kandili Government Hospital");
        hospitalMap.put("tirupathur_madhanur", "Madhanur Government Hospital");
        hospitalMap.put("tirupathur_pallikonda", "Pallikonda Government Hospital");
        hospitalMap.put("tirupathur_elagiri", "Elagiri Government Hospital");
        hospitalMap.put("tirupathur_odalvadi", "Odalvadi Government Hospital");
        hospitalMap.put("tirupathur_parvathipuram", "Parvathipuram Government Hospital");
        hospitalMap.put("tirupathur_melsilupatti", "Melsilupatti Government Hospital");
        hospitalMap.put("tirupathur_thimmapettai", "Thimmapettai Government Hospital");
        hospitalMap.put("tirupathur_veerapanur", "Veerapanur Government Hospital");
        hospitalMap.put("tirupathur_kuppanatham", "Kuppanatham Government Hospital");

        // ==================== TIRUPPUR DISTRICT ====================
        hospitalMap.put("tiruppur_tiruppur", "Government Hospital Tiruppur");
        hospitalMap.put("tiruppur_avinashipalayam", "Avinashipalayam Government Hospital");
        hospitalMap.put("tiruppur_dharapuram", "Dharapuram Government Hospital");
        hospitalMap.put("tiruppur_udumalpet", "Udumalpet Government Hospital");
        hospitalMap.put("tiruppur_madathukulam", "Madathukulam Government Hospital");
        hospitalMap.put("tiruppur_kangeyam", "Kangeyam Government Hospital");
        hospitalMap.put("tiruppur_palladam", "Palladam Government Hospital");
        hospitalMap.put("tiruppur_mulanur", "Mulanur Government Hospital");
        hospitalMap.put("tiruppur_vellakovil", "Vellakovil Government Hospital");
        hospitalMap.put("tiruppur_kolathupalayam", "Kolathupalayam Government Hospital");
        hospitalMap.put("tiruppur_veerapandi", "Veerapandi Government Hospital");
        hospitalMap.put("tiruppur_samalapuram", "Samalapuram Government Hospital");
        hospitalMap.put("tiruppur_mangalam", "Mangalam Government Hospital");
        hospitalMap.put("tiruppur_kunnathur", "Kunnathur Government Hospital");
        hospitalMap.put("tiruppur_chettipalayam", "Chettipalayam Government Hospital");

        // ==================== TIRUVALLUR DISTRICT ====================
        hospitalMap.put("tiruvallur_tiruvallur", "Government Hospital Tiruvallur");
        hospitalMap.put("tiruvallur_ambattur", "Ambattur Government Hospital");
        hospitalMap.put("tiruvallur_avadi", "Avadi Government Hospital");
        hospitalMap.put("tiruvallur_poonamallee", "Poonamallee Government Hospital");
        hospitalMap.put("tiruvallur_thiruninravur", "Thiruninravur Government Hospital");
        hospitalMap.put("tiruvallur_tiruttani", "Tiruttani Government Hospital");
        hospitalMap.put("tiruvallur_gummidipoondi", "Gummidipoondi Government Hospital");
        hospitalMap.put("tiruvallur_ponneri", "Ponneri Government Hospital");
        hospitalMap.put("tiruvallur_minjur", "Minjur Government Hospital");
        hospitalMap.put("tiruvallur_red hills", "Red Hills Government Hospital");
        hospitalMap.put("tiruvallur_madhavaram", "Madhavaram Government Hospital");
        hospitalMap.put("tiruvallur_kadambathur", "Kadambathur Government Hospital");
        hospitalMap.put("tiruvallur_pallipattu", "Pallipattu Government Hospital");
        hospitalMap.put("tiruvallur_pulicat", "Pulicat Government Hospital");
        hospitalMap.put("tiruvallur_sholavaram", "Sholavaram Government Hospital");

        // ==================== TIRUVANNAMALAI DISTRICT ====================
        hospitalMap.put("tiruvannamalai_tiruvannamalai", "Government Hospital Tiruvannamalai");
        hospitalMap.put("tiruvannamalai_arani", "Arani Government Hospital");
        hospitalMap.put("tiruvannamalai_chettupattu", "Chettupattu Government Hospital");
        hospitalMap.put("tiruvannamalai_vandavasi", "Vandavasi Government Hospital");
        hospitalMap.put("tiruvannamalai_polur", "Polur Government Hospital");
        hospitalMap.put("tiruvannamalai_chengam", "Chengam Government Hospital");
        hospitalMap.put("tiruvannamalai_thandarampattu", "Thandarampattu Government Hospital");
        hospitalMap.put("tiruvannamalai_keelpennathur", "Keelpennathur Government Hospital");
        hospitalMap.put("tiruvannamalai_kanji", "Kanji Government Hospital");
        hospitalMap.put("tiruvannamalai_jawadhu hills", "Jawadhu Hills Government Hospital");
        hospitalMap.put("tiruvannamalai_ananthur", "Ananthur Government Hospital");
        hospitalMap.put("tiruvannamalai_peranamallur", "Peranamallur Government Hospital");
        hospitalMap.put("tiruvannamalai_vedanthavadi", "Vedanthavadi Government Hospital");
        hospitalMap.put("tiruvannamalai_kilpennathur", "Kilpennathur Government Hospital");
        hospitalMap.put("tiruvannamalai_melmalaiyanur", "Melmalaiyanur Government Hospital");

        // ==================== TIRUVARUR DISTRICT ====================
        hospitalMap.put("tiruvarur_tiruvarur", "Government Hospital Tiruvarur");
        hospitalMap.put("tiruvarur_mannargudi", "Mannargudi Government Hospital");
        hospitalMap.put("tiruvarur_nannilam", "Nannilam Government Hospital");
        hospitalMap.put("tiruvarur_kodavasal", "Kodavasal Government Hospital");
        hospitalMap.put("tiruvarur_needamangalam", "Needamangalam Government Hospital");
        hospitalMap.put("tiruvarur_korukkai", "Korukkai Government Hospital");
        hospitalMap.put("tiruvarur_kottur", "Kottur Government Hospital");
        hospitalMap.put("tiruvarur_muthupettai", "Muthupettai Government Hospital");
        hospitalMap.put("tiruvarur_valangaiman", "Valangaiman Government Hospital");
        hospitalMap.put("tiruvarur_alundur", "Alundur Government Hospital");
        hospitalMap.put("tiruvarur_karuvakkurichi", "Karuvakkurichi Government Hospital");
        hospitalMap.put("tiruvarur_thirukannamangai", "Thirukannamangai Government Hospital");
        hospitalMap.put("tiruvarur_thiruthuraipoondi", "Thiruthuraipoondi Government Hospital");
        hospitalMap.put("tiruvarur_puthagaram", "Puthagaram Government Hospital");
        hospitalMap.put("tiruvarur_mavur", "Mavur Government Hospital");

        // ==================== VELLORE DISTRICT ====================
        hospitalMap.put("vellore_vellore", "Government Vellore Medical College Hospital");
        hospitalMap.put("vellore_katpadi", "Katpadi Government Hospital");
        hospitalMap.put("vellore_ranipet", "Ranipet Government Hospital");
        hospitalMap.put("vellore_arcot", "Arcot Government Hospital");
        hospitalMap.put("vellore_walajapet", "Walajapet Government Hospital");
        hospitalMap.put("vellore_gudiyatham", "Gudiyatham Government Hospital");
        hospitalMap.put("vellore_vaniyambadi", "Vaniyambadi Government Hospital");
        hospitalMap.put("vellore_ambur", "Ambur Government Hospital");
        hospitalMap.put("vellore_pernampet", "Pernampet Government Hospital");
        hospitalMap.put("vellore_kalavai", "Kalavai Government Hospital");
        hospitalMap.put("vellore_sholinghur", "Sholinghur Government Hospital");
        hospitalMap.put("vellore_nemili", "Nemili Government Hospital");
        hospitalMap.put("vellore_oyyur", "Oyyur Government Hospital");
        hospitalMap.put("vellore_kandili", "Kandili Government Hospital");
        hospitalMap.put("vellore_madhanur", "Madhanur Government Hospital");

        // ==================== VILLUPURAM DISTRICT ====================
        hospitalMap.put("villupuram_villupuram", "Villupuram Government Medical College Hospital");
        hospitalMap.put("villupuram_tindivanam", "Tindivanam Government Hospital");
        hospitalMap.put("villupuram_gingee", "Gingee Government Hospital");
        hospitalMap.put("villupuram_vikravandi", "Vikravandi Government Hospital");
        hospitalMap.put("villupuram_vanur", "Vanur Government Hospital");
        hospitalMap.put("villupuram_marakkanam", "Marakkanam Government Hospital");
        hospitalMap.put("villupuram_mailam", "Mailam Government Hospital");
        hospitalMap.put("villupuram_melmalayanur", "Melmalayanur Government Hospital");
        hospitalMap.put("villupuram_koliyanur", "Koliyanur Government Hospital");
        hospitalMap.put("villupuram_kandachipuram", "Kandachipuram Government Hospital");
        hospitalMap.put("villupuram_mundiyambakkam", "Mundiyambakkam Government Hospital");
        hospitalMap.put("villupuram_thirukoilur", "Thirukoilur Government Hospital");
        hospitalMap.put("villupuram_ulagankathan", "Ulagankathan Government Hospital");
        hospitalMap.put("villupuram_mamallapuram", "Mamallapuram Government Hospital");
        hospitalMap.put("villupuram_kanjanur", "Kanjanur Government Hospital");

        // ==================== VIRUDHUNAGAR DISTRICT ====================
        hospitalMap.put("virudhunagar_virudhunagar", "Government Hospital Virudhunagar");
        hospitalMap.put("virudhunagar_sivakasi", "Sivakasi Government Hospital");
        hospitalMap.put("virudhunagar_srivilliputhur", "Srivilliputhur Government Hospital");
        hospitalMap.put("virudhunagar_rajapalayam", "Rajapalayam Government Hospital");
        hospitalMap.put("virudhunagar_sattur", "Sattur Government Hospital");
        hospitalMap.put("virudhunagar_aruppukottai", "Aruppukottai Government Hospital");
        hospitalMap.put("virudhunagar_kariapatti", "Kariapatti Government Hospital");
        hospitalMap.put("virudhunagar_tiruchuli", "Tiruchuli Government Hospital");
        hospitalMap.put("virudhunagar_narikkudi", "Narikkudi Government Hospital");
        hospitalMap.put("virudhunagar_mallankinaru", "Mallankinaru Government Hospital");
        hospitalMap.put("virudhunagar_watrap", "Watrap Government Hospital");
        hospitalMap.put("virudhunagar_chettikurichi", "Chettikurichi Government Hospital");
        hospitalMap.put("virudhunagar_seithur", "Seithur Government Hospital");
        hospitalMap.put("virudhunagar_veppampattu", "Veppampattu Government Hospital");
        hospitalMap.put("virudhunagar_puliyangudi", "Puliyangudi Government Hospital");
    }
    
    public static String getHospital(String district, String town) {
        String key = district.toLowerCase() + "_" + town.toLowerCase();
        return hospitalMap.getOrDefault(key, "Nearest Government Hospital");
    }
    
    public static void addHospitalLog(String message) {
        String logEntry = "[" + new Date() + "]  HOSPITAL: " + message;
        hospitalLogs.add(logEntry);
    }
    
    public static void viewHospitalLog() {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("                     HOSPITAL LOG");
        System.out.println("═".repeat(70));
        
        if (hospitalLogs.isEmpty()) {
            System.out.println("No hospital logs yet.");
        } else {
            for (String log : hospitalLogs) {
                System.out.println(log);
            }
        }
        System.out.println("═".repeat(70));
    }
    
    public static void viewAllHospitals() {
        System.out.println("\n" + "═".repeat(80));
        System.out.println(" HOSPITAL DATABASE (Total: " + hospitalMap.size() + ")");
        System.out.println("═".repeat(80));
        
        TreeMap<String, String> sorted = new TreeMap<>(hospitalMap);
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
    
    public static void viewHospitalsByDistrict(String district) {
        System.out.println("\n" + "═".repeat(70));
        System.out.println("HOSPITALS IN " + district.toUpperCase());
        System.out.println("═".repeat(70));
        
        int count = 0;
        for (Map.Entry<String, String> entry : hospitalMap.entrySet()) {
            if (entry.getKey().startsWith(district.toLowerCase() + "_")) {
                count++;
                String[] parts = entry.getKey().split("_");
                String town = parts.length > 1 ? parts[1] : "";
                System.out.printf("  %-3d %-25s %s\n", count, town, entry.getValue());
            }
        }
        if (count == 0) System.out.println("  No hospitals found!");
        System.out.println("═".repeat(70));
        System.out.println("  Total: " + count + " hospitals");
    }
    
    public static void searchHospital(String searchTerm) {
        System.out.println("\n🔍 SEARCHING: " + searchTerm);
        int count = 0;
        for (Map.Entry<String, String> entry : hospitalMap.entrySet()) {
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
    
    public static void addHospital(String district, String town, String hospitalName) {
        String key = district.toLowerCase() + "_" + town.toLowerCase();
        if (hospitalMap.containsKey(key)) {
            System.out.println(" Hospital already exists!");
            return;
        }
        hospitalMap.put(key, hospitalName);
        addHospitalLog("ADDED: " + hospitalName + " at " + district + "/" + town);
        saveToFile();
        System.out.println(" Hospital added successfully!");
    }
    
    public static void updateHospital(String district, String town, String newHospitalName) {
        String key = district.toLowerCase() + "_" + town.toLowerCase();
        if (hospitalMap.containsKey(key)) {
            String oldName = hospitalMap.get(key);
            hospitalMap.put(key, newHospitalName);
            addHospitalLog("UPDATED: " + oldName + " → " + newHospitalName);
            saveToFile();
            System.out.println(" Hospital updated successfully!");
        } else {
            System.out.println(" Hospital not found!");
        }
    }
    
    public static void deleteHospital(String district, String town) {
        String key = district.toLowerCase() + "_" + town.toLowerCase();
        String removed = hospitalMap.remove(key);
        if (removed != null) {
            addHospitalLog("DELETED: " + removed);
            saveToFile();
            System.out.println(" Hospital deleted successfully!");
        } else {
            System.out.println(" Hospital not found!");
        }
    }
    
    public static void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DATA_FILE))) {
            for (Map.Entry<String, String> entry : hospitalMap.entrySet()) {
                writer.println(entry.getKey() + "|" + entry.getValue());
            }
        } catch (IOException e) {}
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE))) {
            for (String log : hospitalLogs) {
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
                    hospitalMap.put(parts[0], parts[1]);
                }
            }
            System.out.println("Loaded " + hospitalMap.size() + " hospitals");
        } catch (IOException e) {}
        
        File logFile = new File(LOG_FILE);
        if (logFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    hospitalLogs.add(line);
                }
            } catch (IOException e) {}
        }
    }
    
    public static int getHospitalCount() { return hospitalMap.size(); }
}