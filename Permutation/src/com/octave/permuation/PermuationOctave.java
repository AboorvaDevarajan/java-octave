package com.octave.permuation;

import dk.ange.octave.OctaveEngine;
import dk.ange.octave.OctaveEngineFactory;
import dk.ange.octave.type.OctaveDouble;

public class PermuationOctave {

	public static void main(String[] args) {

		double VM = 4;
		double PM = 6;

		permutation(VM, PM);
	}

	public static void permutation(double nVM, double nPM) {

		OctaveEngine octave = new OctaveEngineFactory().getScriptEngine();
		octave.eval("result = permute_repetitions([1,2,3,4],6);");
		for (int i = 1; i <= Math.pow(nVM, nPM); i++) {
			System.out.println("i: " + i);
			octave.eval("x = result(" + i + ",:)");
			OctaveDouble varX = (OctaveDouble) octave.get("x");
		}

		octave.close();
	}
}
