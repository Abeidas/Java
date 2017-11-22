/*
 * VierteÜb.cpp
 *
 *  Created on: 17.05.2015
 *      Author: Ahmad
 */

#include "VierteÜb.h"

VierteÜb::VierteÜb() {
	int x = 14; int y = 19; int *p; int *q;
	p = &x;
	*p = 22;
	q = &y;
	p = q;
	y = 21;
	*p = x;


}

VierteÜb::~VierteÜb() {
	// TODO Auto-generated destructor stub
}

