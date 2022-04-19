#include <stdio.h>
#include <sys/types.h>
#include <stdlib.h>
#include <unistd.h>
int main() {
	int descr[3];
	pipe(descr);

	dup2(descr[1],1);
	printf("HELLO");
	printf("BABY");
	

	return 0;

}
