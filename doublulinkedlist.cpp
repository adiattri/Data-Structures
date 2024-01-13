#include<iostream>
using namespace std;

class Node{
  public:
  int data;
  Node* next;
  Node* prev;


Node(int d){
  this -> data = d;
  this -> next = NULL;
  this -> prev = NULL;
}

};
//traversing a linked list
void print(Node* head){
  Node* temp = head;

  while(temp != NULL){
    cout<<temp -> data<<" ";
    temp = temp -> next;
  }
  cout<<endl;
  }
//gives length of linked list
int getLength(Node* head){
  int cnt = 0;
  Node* temp = head;
  while(temp != NULL){
    cnt++;
    temp = temp -> next;
  }
  return cnt;
}

void inserAtHead(Node* &head, Node* &tail, int data){
  if(head == NULL){
    Node* temp = new Node(data);
    head = temp;
    tail = temp;
  }
  else{
    Node* temp = new Node(data);
    temp -> next = head;
    head -> prev = temp;
    head = temp;
  }

}

void insertAtTail(Node* &tail, Node* &head, int data){
  if(tail == NULL){
    Node* temp = new Node(data);
    tail = temp;
    head = temp;
  }
  else{
    Node* temp = new Node(data);
    tail -> next = temp;
    temp -> prev = tail;
    tail = temp;
  }

}

void insertAtPosition(Node* &head, Node* &tail, int position, int data){
  //inserting at first position
  if(position == 1){
    inserAtHead(head,tail, data);
    return;
  }
  Node* temp = head;
  int cnt = 1;
  while(cnt < position-1){
    temp = temp -> next;
    cnt++;
 }

  if(temp -> next == NULL){
    insertAtTail(tail, head, data);
    return;
  }
  Node* nodeToInsert = new Node(data);
  nodeToInsert -> next = temp -> next;
  temp -> next -> prev = nodeToInsert;
  temp -> next = nodeToInsert;
  nodeToInsert -> prev = temp;
  }


int main(){
  Node* node1 = new Node(10);
  Node* head = NULL;
  Node* tail = NULL;
  print(head);

  cout<<getLength(head)<<endl;
  inserAtHead(head, tail, 11);
  print(head);

  insertAtTail(tail, head, 12);
  print(head);

  insertAtPosition(head, tail, 2, 100);
  print(head);

  return 0;

}