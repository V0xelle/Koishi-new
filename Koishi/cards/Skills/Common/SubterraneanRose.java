/*    */ package Koishi.cards.Skills.Common;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.actions.SubterraneanRoseAction;
/*    */ import Koishi.cards.AbstractIdCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class SubterraneanRose
/*    */   extends AbstractIdCard {
/* 15 */   public static final String ID = KoishiMod.makeID(SubterraneanRose.class.getSimpleName());
/* 16 */   public static final String IMG = KoishiMod.makeCardPath("SubterraneanRose.png");
/*    */   
/* 18 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.COMMON;
/* 19 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;
/* 20 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 21 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 1;
/*    */   
/*    */   private static final int BLOCK = 7;
/*    */   
/*    */   private static final int UPGRADE_PLUS_BLOCK = 2;
/*    */   private static final int THORNS = 5;
/*    */   private static final int UPGRADE_PLUS_THORNS = 1;
/*    */   
/*    */   public SubterraneanRose() {
/* 32 */     super(ID, IMG, 1, TYPE, COLOR, RARITY, TARGET);
/* 33 */     this.baseBlock = 7;
/* 34 */     this.magicNumber = this.baseMagicNumber = 5;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 39 */     KoishiMod.runAnimation("kick");
/* 40 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new SubterraneanRoseAction(this));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getTitleFontSize() {
/* 46 */     return 18.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 52 */     if (!this.upgraded) {
/* 53 */       upgradeName();
/* 54 */       upgradeBlock(2);
/* 55 */       upgradeMagicNumber(1);
/* 56 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Common/SubterraneanRose.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */