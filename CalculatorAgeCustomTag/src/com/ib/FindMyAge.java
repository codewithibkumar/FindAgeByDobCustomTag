package com.ib;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

public class FindMyAge extends TagSupport{

	JspWriter out;
	String dob;
	
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public int doStartTag() throws JspException {
		out = pageContext.getOut();
		String date[] =	dob.split("-");
		int year = Integer.parseInt(date[0]);
		int month = Integer.parseInt(date[1]);
		int day = Integer.parseInt(date[2]);
		int age = Period.between(LocalDate.of(year,month,day), LocalDate.now()).getYears();
		try {
			out.println("Your date of birth is: "+dob);
			out.println("Your age is: "+age);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.doStartTag();
	}
}
