package com.ib;

import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

public class ShowDate extends TagSupport {

	JspWriter out;
	@Override
	public int doStartTag() throws JspException {
		out = pageContext.getOut();
		
		try {
			out.println(LocalDate.now());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.doStartTag();
	}
	@Override
	public int doEndTag() throws JspException {
		
		return super.doEndTag();
	}
}
