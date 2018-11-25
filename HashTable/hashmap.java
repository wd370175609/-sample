/*
Load Factor
If n be the total number of buckets we decided to fill initially say 10 and let’s say 7 of them got filled now, 
so the load factor is 7/10=0.7.
In our implementation whenever we add a key value pair to the Hash Table we check the load factor if it is greater than 0.7 
we double the size of our hash table.
load factor = size of key / size of bucket

implementation refer to https://www.geeksforgeeks.org/implementing-our-own-hash-table-with-separate-chaining-in-java/
trick:
1.rehash will be in add().  and in rehash function will also use add() recursively for convenience.
2. do not forget <K, V>
3.remove() function, there are some corner case like whether the element should be inserted at the beginning or middle.

*/
class HashNode<K, V> {
	K key;
	V value;
	HashNode<K, V> next;
	HashNode(K key, V value){
		this.key=key;
		this.value=value;
		next=null;
	}
}

class HT<K, V>{
	private int size;		//size of HT
	private int bucket_size; 	//size of bucket
	private List<HashNode<K, V>> bucket;
	HT(){
		bucket = new ArrayList<>();
		size=0;
		bucket_size=10;
		for(int i=0;i<bucket_size;i++){
			bucket.add(null);
		}
	}
	public int size() { return size; } 
	public boolean isEmpty() { return size() == 0; } 

	private int getBucketIndex(K key){
		int index=key.hashCode();
		return index % bucket_size;
	}

	public V remove(K key) {
		int index = getBucketIndex(key);
		HashNode<K, V> head=bucket.get(index);
		HashNode<K, V> pre=null;
		while(head!=null){
			if(head.key.equals(key))
				break;

			pre=head;
			head=head.next;
		}
		// If key was not there 
		if(head==null)
			return null;

		// Remove key 
		if(pre==null)
			bucket.set(index, head.next); 
		else
			pre.next=head.next;
		size--;
		return head.value;
	}

	public V get(K key) {
		int index = getBucketIndex(key);
		HashNode<K, V> head=bucket.get(index);

		// Search key in chain 
		while(head!=null){
			if(head.key.equals(key)){
				return head.value;
			}
			head=head.next;
		}
		return null;
	}

	public void add(K key, V value) {
		int index = getBucketIndex(key);
		HashNode<K, V> head=bucket.get(index);
		HashNode<K, V> temp=head;
		while(temp!=null){
			if(temp.key.equals(key)){
				temp.value=value;
				return;
			}
			temp=temp.next;
		}
		HashNode<K, V> node = new HashNode<>(key,value);
		node.next=head;
		bucket.set(index, node);
		size++;

		// If load factor goes beyond threshold, then 
		// double hash table size 
		if(1.0*size/bucket_size>0.7){
			List<HashNode<K, V>> list=bucket;
			bucket_size*=2;
			bucket = new ArrayList<>();
			for(int i=0;i<bucket_size;i++)
				bucket.add(null);
			for(HashNode<K, V> item:list){
				while(item!=null){
					add(item.key, item.value);
					item=item.next;
				}
			}
		}




	}
