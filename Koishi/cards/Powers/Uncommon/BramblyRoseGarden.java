/*    */ package Koishi.cards.Powers.Uncommon;
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.powers.ThornsPower;
/*    */ 
/*    */ public class BramblyRoseGarden extends AbstractDefaultCard {
/* 16 */   public static final String ID = KoishiMod.makeID(BramblyRoseGarden.class.getSimpleName());
/* 17 */   public static final String IMG = KoishiMod.makeCardPath("BramblyRoseGarden.png");
/*    */   
/* 19 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.UNCOMMON;
/* 20 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;
/* 21 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.POWER;
/* 22 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 2;
/*    */   
/*    */   private static final int THORNS = 5;
/*    */   private static final int UPGRADE_PLUS_THORNS = 3;
/*    */   
/*    */   public BramblyRoseGarden() {
/* 30 */     super(ID, IMG, 2, TYPE, COLOR, RARITY, TARGET);
/* 31 */     this.magicNumber = this.baseMagicNumber = 5;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 36 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new ThornsPower((AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getTitleFontSize() {
/* 42 */     return 18.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 48 */     if (!this.upgraded) {
/* 49 */       upgradeName();
/* 50 */       upgradeMagicNumber(3);
/* 51 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Powers/Uncommon/BramblyRoseGarden.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */