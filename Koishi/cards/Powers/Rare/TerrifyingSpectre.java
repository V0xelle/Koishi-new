/*    */ package Koishi.cards.Powers.Rare;
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import Koishi.powers.TerrifyingSpectrePower;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class TerrifyingSpectre extends AbstractDefaultCard {
/* 16 */   public static final String ID = KoishiMod.makeID(TerrifyingSpectre.class.getSimpleName());
/* 17 */   public static final String IMG = KoishiMod.makeCardPath("TerrifyingSpectre.png");
/*    */   
/* 19 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.RARE;
/* 20 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;
/* 21 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.POWER;
/* 22 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 2;
/*    */   
/*    */   private static final int UPGRADED_COST = 1;
/*    */   private static final int EFFECT = 1;
/*    */   
/*    */   public TerrifyingSpectre() {
/* 30 */     super(ID, IMG, 2, TYPE, COLOR, RARITY, TARGET);
/* 31 */     this.magicNumber = this.baseMagicNumber = 1;
/* 32 */     KoishiMod.setBackground((CustomCard)this, 2);
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 37 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new TerrifyingSpectrePower((AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getTitleFontSize() {
/* 43 */     return 20.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 49 */     if (!this.upgraded) {
/* 50 */       upgradeName();
/* 51 */       upgradeBaseCost(1);
/* 52 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Powers/Rare/TerrifyingSpectre.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */