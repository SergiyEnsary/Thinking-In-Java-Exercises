package chapter15practices;

import chapter13practices.Generator;

interface SkipGenerator<T> extends Generator<T> { 
	T next();	
	T next(int n); 
}