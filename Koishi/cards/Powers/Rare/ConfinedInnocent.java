/*    */ package Koishi.cards.Powers.Rare;
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import Koishi.powers.ConfinedInnocentPower;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class ConfinedInnocent extends AbstractDefaultCard {
/* 16 */   public static final String ID = KoishiMod.makeID(ConfinedInnocent.class.getSimpleName());
/* 17 */   public static final String IMG = KoishiMod.makeCardPath("ConfinedInnocent.png");
/*    */   
/* 19 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.RARE;
/* 20 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;
/* 21 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.POWER;
/* 22 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 1;
/*    */   
/*    */   public static final int HP_LOSS = 1;
/*    */   
/*    */   private static final int EFFECT = 3;
/*    */   private static final int UPGRADE_PLUS_EFFECT = 1;
/*    */   
/*    */   public ConfinedInnocent() {
/* 32 */     super(ID, IMG, 1, TYPE, COLOR, RARITY, TARGET);
/* 33 */     this.magicNumber = this.baseMagicNumber = 3;
/* 34 */     this.defaultSecondMagicNumber = this.defaultBaseSecondMagicNumber = 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 39 */     KoishiMod.runAnimation("spellB");
/* 40 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new ConfinedInnocentPower((AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getTitleFontSize() {
/* 46 */     return 21.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 52 */     if (!this.upgraded) {
/* 53 */       upgradeName();
/* 54 */       upgradeMagicNumber(1);
/* 55 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Powers/Rare/ConfinedInnocent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */