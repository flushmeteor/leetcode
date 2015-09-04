此题有三点：

1.要作交换，不需要将原始节点进行重新排布，直接用一个linkedlist将所有节点连接起来，然后对每个节点中的指针进行修改即可。

2.首先，如果节点为空或者只有一个节点，直接返回即可。节点数大于等于2的时候，做完交换之后的序列有一个特点：所有偶数节点指向其前面节点；奇数节点k指向节点k+3；

3.交换完后的链表尾部节点需要处理，如果总数为偶数，需将倒数第二个节点的指针置为空；如果总数为奇数，需将倒数第三个节点的指针指向最后一个节点，并将最后一个节点的指针置为空。

另外，需注意，交换完后，第二个节点成了头节点。