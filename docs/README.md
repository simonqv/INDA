Task 2
* **What happens if you switch the order of the statements
  `wgp.Wait()` and `close(ch)` in the end of the `main` function?**
  
  The channel is closed before it is used. So when the program tires to use the channel an error message appears.
  
  panic: send on closed channel

  
  
* **What happens if you move the `close(ch)` from the `main` function
  and instead close the channel in the end of the function
  `Produce`**
  
  When tested, the producer 1 is finnished first and then closes the channel, stopping the other producers from executing. 
  If one is done it closes the channel and then stops the rest from using it! Not good.
  
  Again: panic: send on closed channel

  
* **What happens if you remove the statement `close(ch)` completely?**

  In this case, nothing. The printout is the same as, it finishes the program. 
  When a channel is no longer used it will be garbage collected. It is only really 
  necessary to close if the receiver is waiting for a close.
  

* **What happens if you increase the number of consumers from 2 to 4?**

  The only difference I notice is that the program runs faster. When using 4 consumers 
  the work is divided between the 4. 4 goroutines are started instead of only 2.

* **Can you be sure all strings prints before the program
  stops?**
  
  Nope. There is a WaitgGoup for the producers, but the consumers. So we can't 
  guarantee that everything prints. So when the producers finish, the main can 
  close the channel stopping the consumer from printing.