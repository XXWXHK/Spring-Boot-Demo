package cn.com.xuxiaowei.demo.servlet;

import com.github.bingoohuang.patchca.custom.ConfigurableCaptchaService;
import com.github.bingoohuang.patchca.filter.predefined.*;
import com.github.bingoohuang.patchca.font.RandomFontFactory;
import com.github.bingoohuang.patchca.utils.encoder.EncoderHelper;
import com.github.bingoohuang.patchca.word.RandomWordFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

/**
 * GitHub 图片验证码 Patchca
 * <p>
 * https://mvnrepository.com/artifact/com.github.bingoohuang/patchca
 *
 * @author xuxiaowei
 */
public class PatchcaHttpServlet extends HttpServlet {

    private static ConfigurableCaptchaService cs = new ConfigurableCaptchaService();

    private static Random random = new Random();

    static {

        /* cs.setColorFactory(new SingleColorFactory(new Color(25, 60, 170))); */
        cs.setColorFactory((colorFactory) -> {
            int[] c = new int[3];
            int i = random.nextInt(c.length);
            for (int fi = 0; fi < c.length; fi++) {
                if (fi == i) {
                    c[fi] = random.nextInt(71);
                } else {
                    c[fi] = random.nextInt(256);
                }
            }
            return new Color(c[0], c[1], c[2]);
        });

        RandomWordFactory randomWordFactory = new RandomWordFactory();

        // 字符范围
        randomWordFactory.setCharacters("23456789abcdefghijkmnpqrstuvwxyzABCDEFGHIJKLMNPQRSTUVWXYZ");

        // 字符数量范围
        randomWordFactory.setMaxLength(5);
        randomWordFactory.setMinLength(3);
        cs.setWordFactory(randomWordFactory);

        // 图片像素
        cs.setHeight(50);
        cs.setWidth(150);

        // 字体大小范围
        RandomFontFactory randomFontFactory = new RandomFontFactory();
        randomFontFactory.setMaxSize(40);
        randomFontFactory.setMinSize(30);
        cs.setFontFactory(randomFontFactory);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取 Session 需要在 getPatchca(req, resp) 之前
        HttpSession session = req.getSession();

        String patchca = getPatchca(req, resp);

        session.setAttribute("patchca", patchca);

    }

    /**
     * 获取图片验证码对应的字符串
     */
    private String getPatchca(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        switch (random.nextInt(5)) {
            case 0:
                cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));
                break;
            case 1:
                cs.setFilterFactory(new MarbleRippleFilterFactory());
                break;
            case 2:
                cs.setFilterFactory(new DoubleRippleFilterFactory());
                break;
            case 3:
                cs.setFilterFactory(new WobbleRippleFilterFactory());
                break;
            case 4:
                cs.setFilterFactory(new DiffuseRippleFilterFactory());
                break;
            default:
        }

        setResponseHeaders(resp);

        return EncoderHelper.getChallangeAndWriteImage(cs, "png", resp.getOutputStream());
    }

    /**
     * 设置图片验证码的响应
     * <p>
     * 禁止图片验证码缓存
     */
    private void setResponseHeaders(HttpServletResponse response) {
        response.setContentType("image/png");
        response.setHeader("Cache-Control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        long time = System.currentTimeMillis();
        response.setDateHeader("Last-Modified", time);
        response.setDateHeader("Date", time);
        response.setDateHeader("Expires", time);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
