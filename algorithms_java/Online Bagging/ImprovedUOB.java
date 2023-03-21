/**
 * Author: Leandro L. Minku (leandro.minku@leicester.ac.uk)
 * Implementation of Undersampling Online Bagging as in
 * WANG, S.; MINKU, L.L.; YAO, X. "Dealing with Multiple Classes in Online Class Imbalance Learning", 
 * Proceedings of the 25th International Joint Conference on Artificial Intelligence (IJCAI'16), July 2016
 * 
 * Please note that this was not the implementation used in the experiments done in the paper above.
 * However, it implements the algorithm proposed in that paper. So, it should reflect those results.
 * 
 */

package moa.classifiers.meta;

import com.yahoo.labs.samoa.instances.Instance;

public class ImprovedUOB extends ImprovedOOB {

	@Override
	public String getPurposeString() {
		return "Undersampling on-line bagging of Wang et al IJCAI 2016.";
	}
	
	public ImprovedUOB() {
		super();
	}

	@Override
	public double calculatePoissonLambda(Instance inst) {
		int minClass = getMinorityClass();
		
		return classSize[minClass] / classSize[(int) inst.classValue()];
		
	}

	// find the index of the class with the smaller size
	protected int getMinorityClass() {
		int indexMin = 0;

		for (int i=1; i<classSize.length; ++i) {
			if (classSize[i] <= classSize[indexMin]) {
				indexMin = i;
			}
		}
		return indexMin;
	}

}