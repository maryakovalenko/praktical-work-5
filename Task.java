
public class Task{

}

class Node
{
    int key;
    Node left, right;
 
    Node(int key) {
        this.key = key;
    }
}
 
class Main
{
    // Рекурсивная функция для выполнения неупорядоченного обхода заданного бинарного дерева
    public static void inorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }
    public static Node constructBST(int[] postorder, int start, int end)
    {

        if (start > end) {
            return null;
        }
 
        // Построим корневой узел поддерева, образованного ключами
        // последовательность в обратном порядке в диапазоне `[start, end]`
        Node node = new Node(postorder[end]);
        // поиск по индексу последнего элемента в текущем диапазоне обратного порядка
        // последовательность, которая меньше значения корневого узла
        int i;
        for (i = end; i >=start; i--)
        {
            if (postorder[i] < node.key) {
                break;
            }
        }
 
        // рекурсивно строим правое поддерево
        node.right = constructBST(postorder, i + 1, end - 1);
 
        // рекурсивно строим левое поддерево
        node.left = constructBST(postorder, start, i);
 
        return node;
    }
 
    /**
     * @param args
     */
    public static void main(String[] args)
    {
 
        int[] postorder = { 11, 9, 18, 14, 21, 6, 27 };
        Node root = constructBST(postorder, 0, postorder.length - 1);
 
        System.out.print("Inorder traversal of BST is ");
 
        inorder(root);
    }
}   
  

