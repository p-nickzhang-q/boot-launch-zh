package com.zh.boot.launch.service;

import com.zh.boot.launch.entities.AjaxResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;

/**
 * Converter处理request以及response数据
 */
//@Service
public class Response2XlsConverter extends AbstractHttpMessageConverter<AjaxResponse> {
    private static final MediaType EXCEL_TYPE = MediaType.valueOf("application/vnd.ms-excel");

    public Response2XlsConverter() {
        super(EXCEL_TYPE);
    }

    @Override
    protected boolean supports(Class<?> aClass) {
        return AjaxResponse.class == aClass;
    }

    @Override
    protected AjaxResponse readInternal(Class<? extends AjaxResponse> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    protected void writeInternal(AjaxResponse ajaxResponse, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        Workbook e = new XSSFWorkbook();
        Sheet sheet = e.createSheet();

        Row row = sheet.createRow(0);

        row.createCell(0).setCellValue(ajaxResponse.getMessage());
        row.createCell(1).setCellValue(ajaxResponse.getData().toString());

        e.write(httpOutputMessage.getBody());
    }
}
