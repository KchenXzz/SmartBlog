package com.kcx.util;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author kcx
 * @version v1.0.0
 * @description
 * @createTime 25/09/2023 10:28 am
 */
public class THUtils {
    private static TemplateEngine te;

    static {
        te = new TemplateEngine();
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setCharacterEncoding("utf-8");
        te.setTemplateResolver(resolver);
    }


    /**
     * 将指定的html 模板 以及上下文对象 输出
     * @param fileName 页面
     * @param context 上下文对象
     */
    public static void print(String fileName, Context context, ServletResponse response){

        String html = te.process(fileName, context);
        response.setContentType("text/html;charset=utf-8");

        try (PrintWriter out = response.getWriter()) {
            out.print(html);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }





}
