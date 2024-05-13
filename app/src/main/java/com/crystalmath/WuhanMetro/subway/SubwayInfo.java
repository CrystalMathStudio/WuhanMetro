package com.crystalmath.WuhanMetro.subway;

import android.util.Pair;

import com.crystalmath.WuhanMetro.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubwayInfo {
    public static Map<Integer, SubwayLine> lineMap;
    public static List<TransferStation> transferStat;

    private static void calcTransfers(){
        Map<String, List<SubwayStation>> map = new HashMap<>();
        SubwayLine[] lines = lineMap.values().toArray(new SubwayLine[0]);

        for (int i = 0; i < lines.length; i++){
            for (int j = 0; j < lines[i].stations.size(); j++){
                SubwayStation station = lines[i].stations.get(j);
                List<SubwayStation> list = map.getOrDefault(station.name, new ArrayList<>());
                list.add(station);
                map.put(station.name, list);
            }
        }

        for (List<SubwayStation> list : map.values()){
            if (list.size() > 1){
                transferStat.add(TransferStation.construct(list));
            }
        }
    }

    static {
        lineMap = new HashMap<>();
        transferStat = new ArrayList<>();

        SubwayLine line1 = new SubwayLine(1, R.color.line_1);
        line1.add(new SubwayStation("汉口北", "420100034364030", 30.711953, 114.329481));
        line1.add(new SubwayStation("滠口新城", "420100034364029", 30.684553, 114.342372));
        line1.add(new SubwayStation("滕子岗", "420100034364028", 30.674527, 114.341474));
        line1.add(new SubwayStation("堤角", "420100034364027", 30.665863, 114.338273));
        line1.add(new SubwayStation("新荣", "420100034364026", 30.657595, 114.332763));
        line1.add(new SubwayStation("丹水池", "420100034364025", 30.643386, 114.330017));
        line1.add(new SubwayStation("徐州新村", "420100034364024", 30.631171, 114.322936));
        line1.add(new SubwayStation("二七路", "420100034364023", 30.625032, 114.318749));
        line1.add(new SubwayStation("头道街", "420100034364022", 30.617818, 114.313923));
        line1.add(new SubwayStation("黄浦路", "420100034364021", 30.608404, 114.308156));
        line1.add(new SubwayStation("三阳路", "420100034364020", 30.598718, 114.301348));
        line1.add(new SubwayStation("大智路", "420100024335017", 30.592581, 114.295038));
        line1.add(new SubwayStation("循礼门", "420100024404014", 30.585234, 114.285992));
        line1.add(new SubwayStation("友谊路", "420100034364017", 30.580865, 114.278415));
        line1.add(new SubwayStation("利济北路", "420100034364016", 30.577433, 114.270119));
        line1.add(new SubwayStation("崇仁路", "420100034364015", 30.573909, 114.261901));
        line1.add(new SubwayStation("硚口路", "420100034364014", 30.571547, 114.250444));
        line1.add(new SubwayStation("太平洋", "420100034364013", 30.574025, 114.240741));
        line1.add(new SubwayStation("宗关", "420100024331016", 30.580306, 114.224975));
        line1.add(new SubwayStation("汉西一路", "420100034364011", 30.585491, 114.218822));
        line1.add(new SubwayStation("古田四路", "420100034364010", 30.589347, 114.211532));
        line1.add(new SubwayStation("古田三路", "420100034364009", 30.593382, 114.20474));
        line1.add(new SubwayStation("古田二路", "420100034364008", 30.597536, 114.196667));
        line1.add(new SubwayStation("古田一路", "420100034364007", 30.604521, 114.183062));
        line1.add(new SubwayStation("舵落口", "420100034364006", 30.609907, 114.169464));
        line1.add(new SubwayStation("竹叶海", "420100034364005", 30.615064, 114.163868));
        line1.add(new SubwayStation("额头湾", "420100034364004", 30.61846, 114.155941));
        line1.add(new SubwayStation("五环大道", "420100034364003", 30.617699, 114.138907));
        line1.add(new SubwayStation("东吴大道", "420100034364002", 30.624968, 114.128567));
        line1.add(new SubwayStation("码头潭公园", "420100024335032", 30.631684, 114.123644));
        line1.add(new SubwayStation("三店", "420100034364032", 30.649056, 114.120804));
        line1.add(new SubwayStation("径河", "420100034364031", 30.659055, 114.120828));

        SubwayLine line11 = new SubwayLine(11, R.color.line_11);
        line11.add(new SubwayStation("武汉东站", "420100024404035", 30.486956, 114.431755));
        line11.add(new SubwayStation("湖口", "900000073743002", 30.487938, 114.448734));
        line11.add(new SubwayStation("光谷同济医院", "900000073743003", 30.485267, 114.466409));
        line11.add(new SubwayStation("光谷生物园", "900000073743004", 30.48761, 114.481231));
        line11.add(new SubwayStation("光谷四路", "900000073743005", 30.489155, 114.492018));
        line11.add(new SubwayStation("光谷五路", "900000073743006", 30.485101, 114.502876));
        line11.add(new SubwayStation("光谷六路", "900000073743007", 30.485028, 114.512862));
        line11.add(new SubwayStation("豹澥", "900000073743008", 30.488736, 114.522905));
        line11.add(new SubwayStation("光谷七路", "900000073743009", 30.488447, 114.534098));
        line11.add(new SubwayStation("长岭山", "900000073743010", 30.487628, 114.563156));
        line11.add(new SubwayStation("未来一路", "900000073743011", 30.484577, 114.585145));
        line11.add(new SubwayStation("未来三路", "900000073743012", 30.48645, 114.605998));
        line11.add(new SubwayStation("左岭", "900000073743013", 30.488119, 114.620662));
        line11.add(new SubwayStation("葛店南站", "900000073743014", 30.48932, 114.660675));

        SubwayLine line16 = new SubwayLine(16, R.color.line_16);
        line16.add(new SubwayStation("国博中心南", "420100024335006", 30.506036, 114.236109));
        line16.add(new SubwayStation("老关村", "420100024335005", 30.49291, 114.225922));
        line16.add(new SubwayStation("南太子湖", "900000090803010", 30.476763, 114.220062));
        line16.add(new SubwayStation("沌口", "900000090803009", 30.462005, 114.20521));
        line16.add(new SubwayStation("小军山", "900000090803008", 30.404752, 114.158383));
        line16.add(new SubwayStation("枫林", "900000090803007", 30.389468, 114.14481));
        line16.add(new SubwayStation("大军山", "900000090803006", 30.375637, 114.132762));
        line16.add(new SubwayStation("桂子湖", "900000090803005", 30.358558, 114.093695));
        line16.add(new SubwayStation("马影河", "900000090803004", 30.341694, 114.068792));
        line16.add(new SubwayStation("协子河", "900000090803003", 30.332275, 114.059869));
        line16.add(new SubwayStation("湾湖", "900000090803002", 30.323551, 114.047088));
        line16.add(new SubwayStation("周家河", "900000090803001", 30.30459, 114.035102));
        line16.add(new SubwayStation("纱帽", "900000090803014", 30.280258, 114.052174));
        line16.add(new SubwayStation("通航机场", "900000090803013", 30.269699, 114.062984));

        SubwayLine line19 = new SubwayLine(19, R.color.line_19);
        line19.add(new SubwayStation("新月溪公园", "900000115789006", 30.47636, 114.502879));
        line19.add(new SubwayStation("光谷五路", "900000073743006", 30.485101, 114.502876));
        line19.add(new SubwayStation("花山河", "900000115789004", 30.541243, 114.512443));
        line19.add(new SubwayStation("花山新城", "900000115789003", 30.554645, 114.504183));
        line19.add(new SubwayStation("鼓架山", "900000115789007", 30.553403, 114.466404));
        line19.add(new SubwayStation("武东", "900000115789002", 30.578433, 114.457159));
        line19.add(new SubwayStation("武汉站西广场", "900000115789001", 30.604844, 114.422911));

        SubwayLine line2 = new SubwayLine(2, R.color.line_2);
        line2.add(new SubwayStation("佛祖岭", "420100024404030", 30.438671, 114.439777));
        line2.add(new SubwayStation("藏龙东街", "420100024404031", 30.437026, 114.429655));
        line2.add(new SubwayStation("秀湖", "420100024404032", 30.447747, 114.421034));
        line2.add(new SubwayStation("金融港北", "420100024404033", 30.461963, 114.420416));
        line2.add(new SubwayStation("黄龙山路", "420100024404034", 30.477465, 114.429936));
        line2.add(new SubwayStation("武汉东站", "420100024404035", 30.486956, 114.431755));
        line2.add(new SubwayStation("佳园路", "420100024404036", 30.500021, 114.430905));
        line2.add(new SubwayStation("光谷大道", "420100024404037", 30.506535, 114.423817));
        line2.add(new SubwayStation("华中科技大学", "420100024404038", 30.50741, 114.414237));
        line2.add(new SubwayStation("珞雄路", "420100024404039", 30.506941, 114.404837));
        line2.add(new SubwayStation("光谷广场", "420100024404002", 30.50576, 114.397169));
        line2.add(new SubwayStation("杨家湾", "420100024404003", 30.505122, 114.382732));
        line2.add(new SubwayStation("虎泉", "420100024404004", 30.512359, 114.370478));
        line2.add(new SubwayStation("广埠屯", "420100024404005", 30.522437, 114.364207));
        line2.add(new SubwayStation("街道口", "420100024404006", 30.526597, 114.353503));
        line2.add(new SubwayStation("宝通寺", "420100024404007", 30.530349, 114.341206));
        line2.add(new SubwayStation("中南路", "420100024404008", 30.537528, 114.332959));
        line2.add(new SubwayStation("洪山广场", "420100024404009", 30.545298, 114.336354));
        line2.add(new SubwayStation("小龟山", "420100024404010", 30.551108, 114.32652));
        line2.add(new SubwayStation("螃蟹岬", "420100024404011", 30.553333, 114.317476));
        line2.add(new SubwayStation("积玉桥", "420100024404012", 30.561284, 114.308679));
        line2.add(new SubwayStation("江汉路", "420100024335016", 30.579581, 114.292306));
        line2.add(new SubwayStation("循礼门", "420100024404014", 30.585234, 114.285992));
        line2.add(new SubwayStation("中山公园", "420100024404015", 30.581962, 114.272845));
        line2.add(new SubwayStation("青年路", "420100024404016", 30.585762, 114.264757));
        line2.add(new SubwayStation("王家墩东", "420100024404017", 30.594245, 114.263288));
        line2.add(new SubwayStation("范湖", "420100024331012", 30.607717, 114.261086));
        line2.add(new SubwayStation("汉口火车站", "420100024404019", 30.615485, 114.254961));
        line2.add(new SubwayStation("长港路", "420100024404020", 30.627168, 114.246021));
        line2.add(new SubwayStation("常青花园", "420100024335024", 30.640564, 114.242435));
        line2.add(new SubwayStation("金银潭", "420100024404022", 30.650412, 114.242807));
        line2.add(new SubwayStation("常青城", "420100024404023", 30.658775, 114.25506));
        line2.add(new SubwayStation("宏图大道", "420100024331002", 30.670353, 114.277759));
        line2.add(new SubwayStation("盘龙城", "420100024404025", 30.700235, 114.259544));
        line2.add(new SubwayStation("巨龙大道", "420100024404026", 30.711596, 114.253845));
        line2.add(new SubwayStation("宋家岗", "420100024404027", 30.723137, 114.237299));
        line2.add(new SubwayStation("航空总部", "420100024404028", 30.732481, 114.227261));
        line2.add(new SubwayStation("天河机场", "420100024404029", 30.770624, 114.216618));

        SubwayLine line21 = new SubwayLine(21, R.color.line_21);
        line21.add(new SubwayStation("后湖大道", "420100024331004", 30.650284, 114.304127));
        line21.add(new SubwayStation("百步亭花园路", "900000075739018", 30.654377, 114.315485));
        line21.add(new SubwayStation("新荣", "420100034364026", 30.657595, 114.332763));
        line21.add(new SubwayStation("幸福湾", "900000075739020", 30.672102, 114.344101));
        line21.add(new SubwayStation("朱家河", "900000075739021", 30.680146, 114.364654));
        line21.add(new SubwayStation("谌家矶", "900000075739022", 30.683869, 114.37312));
        line21.add(new SubwayStation("青龙", "900000075739023", 30.70546, 114.390414));
        line21.add(new SubwayStation("高车", "900000075739024", 30.713601, 114.40904));
        line21.add(new SubwayStation("武湖", "900000075739025", 30.707017, 114.42999));
        line21.add(new SubwayStation("沙口", "900000075739026", 30.709197, 114.477733));
        line21.add(new SubwayStation("军民村", "900000075739027", 30.709985, 114.515236));
        line21.add(new SubwayStation("武生院", "900000075739028", 30.708536, 114.525709));
        line21.add(new SubwayStation("阳逻", "900000075739029", 30.703571, 114.553039));
        line21.add(new SubwayStation("阳逻开发区", "900000075739030", 30.701603, 114.567772));
        line21.add(new SubwayStation("施岗", "900000075739031", 30.706234, 114.600916));
        line21.add(new SubwayStation("金台", "900000075739032", 30.713671, 114.619116));

        SubwayLine line3 = new SubwayLine(3, R.color.line_3);
        line3.add(new SubwayStation("沌阳大道", "420100024331025", 30.489376, 114.157139));
        line3.add(new SubwayStation("东风公司", "420100024331024", 30.500107, 114.166088));
        line3.add(new SubwayStation("体育中心", "420100024331023", 30.506039, 114.170981));
        line3.add(new SubwayStation("三角湖", "420100024331022", 30.516507, 114.179686));
        line3.add(new SubwayStation("汉阳客运站", "420100024331021", 30.527803, 114.189054));
        line3.add(new SubwayStation("四新大道", "420100024331020", 30.535228, 114.194631));
        line3.add(new SubwayStation("陶家岭", "420100024331019", 30.545591, 114.201851));
        line3.add(new SubwayStation("龙阳村", "420100024331018", 30.552879, 114.206329));
        line3.add(new SubwayStation("王家湾", "420100024331017", 30.562121, 114.210348));
        line3.add(new SubwayStation("宗关", "420100024331016", 30.580306, 114.224975));
        line3.add(new SubwayStation("双墩", "420100024331015", 30.58666, 114.232026));
        line3.add(new SubwayStation("武汉商务区", "420100024331014", 30.597587, 114.246879));
        line3.add(new SubwayStation("云飞路", "420100024331013", 30.605164, 114.252144));
        line3.add(new SubwayStation("范湖", "420100024331012", 30.607717, 114.261086));
        line3.add(new SubwayStation("菱角湖", "420100024331011", 30.604121, 114.27579));
        line3.add(new SubwayStation("香港路", "420100024331010", 30.605235, 114.284769));
        line3.add(new SubwayStation("惠济二路", "420100024331009", 30.612937, 114.291463));
        line3.add(new SubwayStation("赵家条", "420100024331008", 30.617866, 114.297076));
        line3.add(new SubwayStation("罗家庄", "420100024331007", 30.623628, 114.303976));
        line3.add(new SubwayStation("二七小路", "420100024331006", 30.628847, 114.307806));
        line3.add(new SubwayStation("兴业路", "420100024331005", 30.641133, 114.30422));
        line3.add(new SubwayStation("后湖大道", "420100024331004", 30.650284, 114.304127));
        line3.add(new SubwayStation("市民之家", "420100024331003", 30.661297, 114.296806));
        line3.add(new SubwayStation("宏图大道", "420100024331002", 30.670353, 114.277759));

        SubwayLine line4 = new SubwayLine(4, R.color.line_4);
        line4.add(new SubwayStation("柏林", "420100034395030", 30.582229, 113.994891));
        line4.add(new SubwayStation("新庙村", "420100034395031", 30.579826, 114.009379));
        line4.add(new SubwayStation("临嶂大道", "420100034395032", 30.57179, 114.02859));
        line4.add(new SubwayStation("蔡甸广场", "420100034395033", 30.573054, 114.041735));
        line4.add(new SubwayStation("凤凰路", "420100034395034", 30.563412, 114.060324));
        line4.add(new SubwayStation("新农", "420100034395035", 30.560522, 114.074791));
        line4.add(new SubwayStation("知音", "420100034395036", 30.556845, 114.091765));
        line4.add(new SubwayStation("集贤", "420100034395037", 30.550087, 114.112285));
        line4.add(new SubwayStation("新天", "420100034395038", 30.552199, 114.126339));
        line4.add(new SubwayStation("黄金口", "420100034395017", 30.564055, 114.145387));
        line4.add(new SubwayStation("孟家铺", "420100034395018", 30.56499, 114.173901));
        line4.add(new SubwayStation("永安堂", "420100034395019", 30.566446, 114.188919));
        line4.add(new SubwayStation("玉龙路", "420100034395020", 30.564519, 114.201403));
        line4.add(new SubwayStation("王家湾", "420100024331017", 30.562121, 114.210348));
        line4.add(new SubwayStation("十里铺", "420100034395022", 30.55932, 114.219444));
        line4.add(new SubwayStation("七里庙", "420100034395023", 30.556688, 114.231208));
        line4.add(new SubwayStation("五里墩", "420100034395024", 30.553977, 114.241105));
        line4.add(new SubwayStation("汉阳火车站", "420100034395025", 30.551732, 114.252849));
        line4.add(new SubwayStation("钟家村", "420100024335011", 30.549283, 114.266158));
        line4.add(new SubwayStation("拦江路", "420100034395027", 30.542917, 114.269012));
        line4.add(new SubwayStation("复兴路", "420100034395028", 30.534309, 114.301225));
        line4.add(new SubwayStation("首义路", "420100034395029", 30.533612, 114.308531));
        line4.add(new SubwayStation("武昌火车站", "420100034395002", 30.530624, 114.316449));
        line4.add(new SubwayStation("梅苑小区", "420100034395003", 30.530916, 114.326149));
        line4.add(new SubwayStation("中南路", "420100024404008", 30.537528, 114.332959));
        line4.add(new SubwayStation("洪山广场", "420100024404009", 30.545298, 114.336354));
        line4.add(new SubwayStation("楚河汉街", "420100034395006", 30.553848, 114.341415));
        line4.add(new SubwayStation("青鱼嘴", "420100034395007", 30.56372, 114.349884));
        line4.add(new SubwayStation("东亭", "420100034395008", 30.570267, 114.355809));
        line4.add(new SubwayStation("岳家嘴", "420100034395009", 30.577109, 114.36201));
        line4.add(new SubwayStation("铁机路", "420100034395010", 30.583897, 114.368895));
        line4.add(new SubwayStation("罗家港", "420100034395011", 30.5928, 114.37154));
        line4.add(new SubwayStation("园林路", "420100034395012", 30.600224, 114.378123));
        line4.add(new SubwayStation("仁和路", "420100034395013", 30.605179, 114.38909));
        line4.add(new SubwayStation("工业四路", "420100034395014", 30.607996, 114.405848));
        line4.add(new SubwayStation("杨春湖", "420100034395015", 30.6053, 114.416353));
        line4.add(new SubwayStation("武汉火车站", "420100034395016", 30.607375, 114.424376));

        SubwayLine line5 = new SubwayLine(5, R.color.line_5);
        line5.add(new SubwayStation("红霞", "900000068659027", 30.430968, 114.261845));
        line5.add(new SubwayStation("黄家湖(武科大)", "900000068659028", 30.443094, 114.262835));
        line5.add(new SubwayStation("中医药大学", "900000068659001", 30.453717, 114.268778));
        line5.add(new SubwayStation("白沙六路", "900000068659002", 30.468726, 114.293232));
        line5.add(new SubwayStation("光霞", "900000068659003", 30.478528, 114.293047));
        line5.add(new SubwayStation("张家湾", "900000068659004", 30.495453, 114.29331));
        line5.add(new SubwayStation("烽火村", "900000068659006", 30.509093, 114.298051));
        line5.add(new SubwayStation("八铺街", "900000068659007", 30.520002, 114.300559));
        line5.add(new SubwayStation("复兴路", "420100034395028", 30.534309, 114.301225));
        line5.add(new SubwayStation("彭刘杨", "900000068659009", 30.541015, 114.30138));
        line5.add(new SubwayStation("司门口黄鹤楼", "900000068659010", 30.546913, 114.302501));
        line5.add(new SubwayStation("昙华林武胜门", "900000068659011", 30.554209, 114.305282));
        line5.add(new SubwayStation("积玉桥", "420100024404012", 30.561284, 114.308679));
        line5.add(new SubwayStation("三层楼", "900000068659013", 30.569462, 114.314532));
        line5.add(new SubwayStation("三角路", "900000068659014", 30.58134, 114.325308));
        line5.add(new SubwayStation("徐家棚", "900000044147008", 30.588494, 114.332095));
        line5.add(new SubwayStation("杨园铁四院", "900000068659016", 30.599653, 114.342932));
        line5.add(new SubwayStation("余家头", "900000068659017", 30.608032, 114.352171));
        line5.add(new SubwayStation("科普公园", "900000068659018", 30.617733, 114.364928));
        line5.add(new SubwayStation("建设二路", "900000068659019", 30.624951, 114.376403));
        line5.add(new SubwayStation("和平公园", "900000068659020", 30.631463, 114.386836));
        line5.add(new SubwayStation("红钢城", "900000068659021", 30.639088, 114.401431));
        line5.add(new SubwayStation("青宜居", "900000068659022", 30.642611, 114.41955));
        line5.add(new SubwayStation("工人村", "900000068659023", 30.631836, 114.425801));
        line5.add(new SubwayStation("武钢", "900000068659024", 30.618931, 114.437232));
        line5.add(new SubwayStation("厂前", "900000068659025", 30.611409, 114.434239));
        line5.add(new SubwayStation("武汉站东广场", "900000068659026", 30.606713, 114.426897));

        SubwayLine line6 = new SubwayLine(6, R.color.line_6);
        line6.add(new SubwayStation("新城十一路", "420100024335033", 30.632773, 114.109439));
        line6.add(new SubwayStation("码头潭公园", "420100024335032", 30.631684, 114.123644));
        line6.add(new SubwayStation("五环体育中心", "420100024335031", 30.634026, 114.136902));
        line6.add(new SubwayStation("二雅路", "420100024335030", 30.633044, 114.153009));
        line6.add(new SubwayStation("海口三路", "420100024335029", 30.634344, 114.167486));
        line6.add(new SubwayStation("金银湖公园", "420100024335028", 30.636899, 114.180894));
        line6.add(new SubwayStation("金银湖", "420100024335027", 30.639308, 114.204948));
        line6.add(new SubwayStation("园博园北", "420100024335026", 30.63799, 114.222603));
        line6.add(new SubwayStation("轻工大学", "420100024335025", 30.63968, 114.234406));
        line6.add(new SubwayStation("常青花园", "420100024335024", 30.640564, 114.242435));
        line6.add(new SubwayStation("杨汊湖", "420100024335023", 30.635814, 114.261081));
        line6.add(new SubwayStation("石桥", "420100024335022", 30.630637, 114.265265));
        line6.add(new SubwayStation("唐家墩", "420100024335021", 30.617653, 114.271276));
        line6.add(new SubwayStation("三眼桥", "420100024335020", 30.610324, 114.275743));
        line6.add(new SubwayStation("香港路", "420100024331010", 30.605235, 114.284769));
        line6.add(new SubwayStation("苗栗路", "420100024335018", 30.598804, 114.289952));
        line6.add(new SubwayStation("大智路", "420100024335017", 30.592581, 114.295038));
        line6.add(new SubwayStation("江汉路", "420100024335016", 30.579581, 114.292306));
        line6.add(new SubwayStation("六渡桥", "420100024335015", 30.574991, 114.28427));
        line6.add(new SubwayStation("汉正街", "420100024335014", 30.571218, 114.274677));
        line6.add(new SubwayStation("武胜路", "420100024335013", 30.569459, 114.268958));
        line6.add(new SubwayStation("琴台", "420100024335012", 30.557559, 114.266282));
        line6.add(new SubwayStation("钟家村", "420100024335011", 30.549283, 114.266158));
        line6.add(new SubwayStation("马鹦路", "420100024335010", 30.537882, 114.266799));
        line6.add(new SubwayStation("建港", "420100024335009", 30.526609, 114.259685));
        line6.add(new SubwayStation("前进村", "420100024335008", 30.520144, 114.253366));
        line6.add(new SubwayStation("国博中心北", "420100024335007", 30.510581, 114.242654));
        line6.add(new SubwayStation("国博中心南", "420100024335006", 30.506036, 114.236109));
        line6.add(new SubwayStation("老关村", "420100024335005", 30.49291, 114.225922));
        line6.add(new SubwayStation("江城大道", "420100024335004", 30.496388, 114.202216));
        line6.add(new SubwayStation("车城东路", "420100024335003", 30.495551, 114.179988));
        line6.add(new SubwayStation("东风公司", "420100024331024", 30.500107, 114.166088));

        SubwayLine line7 = new SubwayLine(7, R.color.line_7);
        line7.add(new SubwayStation("横店", "900000044148028", 30.804287, 114.289753));
        line7.add(new SubwayStation("裕福路", "900000044148029", 30.785748, 114.278294));
        line7.add(new SubwayStation("天阳大道", "900000044148030", 30.765499, 114.270219));
        line7.add(new SubwayStation("腾龙大道", "900000044148031", 30.727857, 114.259856));
        line7.add(new SubwayStation("巨龙大道", "420100024404026", 30.711596, 114.253845));
        line7.add(new SubwayStation("汤云海路", "900000044148033", 30.699759, 114.237858));
        line7.add(new SubwayStation("马池", "900000044148034", 30.655554, 114.225407));
        line7.add(new SubwayStation("园博园北", "420100024335026", 30.63799, 114.222603));
        line7.add(new SubwayStation("园博园", "900000044148002", 30.618327, 114.225873));
        line7.add(new SubwayStation("常码头", "900000044148003", 30.604632, 114.23479));
        line7.add(new SubwayStation("武汉商务区", "420100024331014", 30.597587, 114.246879));
        line7.add(new SubwayStation("王家墩东", "420100024404017", 30.594245, 114.263288));
        line7.add(new SubwayStation("取水楼", "900000044148006", 30.597634, 114.274655));
        line7.add(new SubwayStation("香港路", "420100024331010", 30.605235, 114.284769));
        line7.add(new SubwayStation("三阳路", "420100034364020", 30.598718, 114.301348));
        line7.add(new SubwayStation("徐家棚", "900000044147008", 30.588494, 114.332095));
        line7.add(new SubwayStation("湖北大学", "900000044148010", 30.577805, 114.32947));
        line7.add(new SubwayStation("新河街", "900000044148011", 30.56256, 114.317111));
        line7.add(new SubwayStation("螃蟹岬", "420100024404011", 30.553333, 114.317476));
        line7.add(new SubwayStation("小东门", "900000044148013", 30.545012, 114.318461));
        line7.add(new SubwayStation("武昌火车站", "420100034395002", 30.530624, 114.316449));
        line7.add(new SubwayStation("瑞安街", "900000044148015", 30.516522, 114.314257));
        line7.add(new SubwayStation("建安街", "900000044148016", 30.504025, 114.313759));
        line7.add(new SubwayStation("湖工大", "900000044148017", 30.483656, 114.313384));
        line7.add(new SubwayStation("板桥", "900000044148020", 30.474294, 114.313464));
        line7.add(new SubwayStation("野芷湖", "900000044147024", 30.460928, 114.319502));
        line7.add(new SubwayStation("新路村", "900000044148021", 30.441596, 114.318411));
        line7.add(new SubwayStation("大花岭", "900000044148022", 30.412329, 114.320107));
        line7.add(new SubwayStation("江夏客厅", "900000044148023", 30.389156, 114.321746));
        line7.add(new SubwayStation("谭鑫培公园", "900000044148024", 30.370536, 114.322041));
        line7.add(new SubwayStation("北华街", "900000044148025", 30.3581, 114.323569));
        line7.add(new SubwayStation("纸坊大街", "900000044148026", 30.344775, 114.324577));
        line7.add(new SubwayStation("青龙山地铁小镇", "900000044148027", 30.3188, 114.334041));

        SubwayLine line8 = new SubwayLine(8, R.color.line_8);
        line8.add(new SubwayStation("金潭路", "900000044147001", 30.6772, 114.28404));
        line8.add(new SubwayStation("宏图大道", "420100024331002", 30.670353, 114.277759));
        line8.add(new SubwayStation("塔子湖", "900000044147003", 30.652594, 114.280364));
        line8.add(new SubwayStation("中一路", "900000044147004", 30.639903, 114.281162));
        line8.add(new SubwayStation("竹叶山", "900000044147005", 30.625318, 114.287104));
        line8.add(new SubwayStation("赵家条", "420100024331008", 30.617866, 114.297076));
        line8.add(new SubwayStation("黄浦路", "420100034364021", 30.608404, 114.308156));
        line8.add(new SubwayStation("徐家棚", "900000044147008", 30.588494, 114.332095));
        line8.add(new SubwayStation("徐东", "900000044147012", 30.587975, 114.346233));
        line8.add(new SubwayStation("汪家墩", "900000044147009", 30.585167, 114.350076));
        line8.add(new SubwayStation("岳家嘴", "420100034395009", 30.577109, 114.36201));
        line8.add(new SubwayStation("梨园", "900000044147011", 30.574832, 114.370081));
        line8.add(new SubwayStation("省博湖北日报", "900000044147013", 30.564871, 114.365294));
        line8.add(new SubwayStation("中南医院", "900000044147014", 30.556807, 114.357089));
        line8.add(new SubwayStation("水果湖", "900000044147015", 30.551863, 114.346346));
        line8.add(new SubwayStation("洪山路", "900000044147016", 30.545492, 114.343812));
        line8.add(new SubwayStation("小洪山", "900000044147017", 30.53561, 114.352367));
        line8.add(new SubwayStation("街道口", "420100024404006", 30.526597, 114.353503));
        line8.add(new SubwayStation("马房山", "900000044147019", 30.516234, 114.350438));
        line8.add(new SubwayStation("文治街", "900000044147020", 30.49999, 114.344226));
        line8.add(new SubwayStation("文昌路", "900000044147021", 30.492013, 114.329911));
        line8.add(new SubwayStation("省农科院", "900000044147022", 30.481799, 114.325808));
        line8.add(new SubwayStation("马湖", "900000044147023", 30.471754, 114.32504));
        line8.add(new SubwayStation("野芷湖", "900000044147024", 30.460928, 114.319502));
        line8.add(new SubwayStation("黄家湖地铁小镇", "900000044147025", 30.436741, 114.298049));
        line8.add(new SubwayStation("军运村", "900000044147026", 30.427348, 114.295024));

        lineMap.put(1, line1);
        lineMap.put(11, line11);
        lineMap.put(16, line16);
        lineMap.put(19, line19);
        lineMap.put(2, line2);
        lineMap.put(21, line21);
        lineMap.put(3, line3);
        lineMap.put(4, line4);
        lineMap.put(5, line5);
        lineMap.put(6, line6);
        lineMap.put(7, line7);
        lineMap.put(8, line8);

        calcTransfers();
    }
}
