package com.nagarro.servicesimpl;

import java.util.Scanner;
import com.nagarro.constants.ConstantsUsed;
import com.nagarro.entity.Tshirts;
import com.nagarro.services.RequirementsOfInput;

public class RequirementsOfInputImpl implements RequirementsOfInput {

	@Override
	public Tshirts input() {
		// TODO Auto-generated method stub
		Scanner obj = new Scanner(System.in);
		System.out.println(ConstantsUsed.ASKING_COLOR);
		String color = obj.next();
		System.out.println(ConstantsUsed.ASKING_SIZE);
		String size = obj.next();
		System.out.println(ConstantsUsed.ASKING_GENDER);
		String gender = obj.next();
		System.out.println(ConstantsUsed.ASKING_OUTPUT_PREFERENCE_OPTION);
		int opPreference = obj.nextInt();
		Tshirts input = new Tshirts();
		input.setColor(color);
		input.setSize(size);
		input.setGender(gender);
		input.setOutputPreference(opPreference);
		return input;
	}

}

