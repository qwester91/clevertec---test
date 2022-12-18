package by.harashchenia.dao.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<StringInReceipt> receipt;
    private Card card;

    public Receipt(Card card) {
        this.card = card;
        this.receipt = new ArrayList<>();
    }


    public void addItemInReceipt (StringInReceipt stringInReceipt){
        this.receipt.add(stringInReceipt);
    }

    public List<StringInReceipt> getReceipt() {
        return receipt;
    }

    public Card getCard() {
        return card;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Qty" + "" + "\t" + "Name " + "\t" + "Sale " +"\t"+ "Price"+ " \t" + "Total\n");
        BigDecimal total = BigDecimal.ZERO;
        BigDecimal localTotal;

        for (StringInReceipt inReceipt : receipt) {
            localTotal = inReceipt.getItem().getCost().multiply(BigDecimal.valueOf(inReceipt.getQty()));
            buffer.append(inReceipt.getQty() + " "+"\t")
                    .append(inReceipt.getItem().getName() + " " + "\t" );
            if(!card.getId().equals(0)){
                buffer.append(card.getDiscount()+"%\t");
               localTotal = localTotal.multiply(BigDecimal.valueOf((100-card.getDiscount())/100));
            }else if(inReceipt.getQty()>=10 && inReceipt.getItem().isInSale()){
                buffer.append("10% \t");
               localTotal = localTotal.multiply(BigDecimal.valueOf(0.9));
            } else
            { buffer.append("    \t");}
                  buffer.append(inReceipt.getItem().getCost()+ " " + "\t")
                    .append( localTotal + " " + "\t"+ "\n");
            total = total.add(localTotal);
        }
        if(!card.getId().equals(0)){
            buffer.append("card  " + card.getId()+"\n");
        }
        buffer.append("Total  " + total);
       return buffer.toString();
//        return "Receipt{" +
//                "receipt=" + receipt +
//                ", card=" + card +
//                '}';
    }
}
