/*
 * BunnyList.h
 *
 *  Created on: 30.10.2015
 *      Author: Ahmad
 */

#ifndef BUNNYLIST_H_
#define BUNNYLIST_H_
class BunnyList {
	public:
	    BunnyList() {
		    head = NULL;

	    }
	    void addBunny(Bunny bunny) {
	    	if (head == NULL) {
		    	head = &bunny;
		    	iterate = &bunny;
		    }  else {
		    	head->setNext(bunny);
		    	iterate = iterate->getNext();
		    }
	    }
	    void killOldBunny(Bunny bunny) {
		    if (&bunny == head) {
			    head = head->getNext();
		    }
	    }
	    void searchForRabbitLadies() {
		    Bunny* hornyMale = head;
		    while (hornyMale->getNext() != NULL) {
			    if (hornyMale->getSex() == 0 && hornyMale->getAge() > 1) {
			    	Bunny* sexyFemale = head;
			    	while (sexyFemale->getNext() != NULL) {
				    	if (sexyFemale->getSex() == 1 && sexyFemale->getAge() > 1) {
					    	Bunny child;
						    child.setColour(sexyFemale->getColour());
					    }
				    }
			    }
		    }
	    }
	    Bunny* getHead() {
	    	return head;
	    }
	private:
	    Bunny *head;
	    Bunny *iterate;
};




#endif /* BUNNYLIST_H_ */
