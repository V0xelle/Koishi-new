/*    */ package Koishi.cards.Skills.Uncommon;
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractIdCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.actions.common.GainBlockAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;
/*    */ 
/*    */ public class RorschachInDanmaku extends AbstractIdCard {
/* 17 */   public static final String ID = KoishiMod.makeID(RorschachInDanmaku.class.getSimpleName());
/* 18 */   public static final String IMG = KoishiMod.makeCardPath("RorschachInDanmaku.png");
/*    */   
/* 20 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.UNCOMMON;
/* 21 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;
/* 22 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 23 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 2;
/*    */   
/*    */   private static final int BLOCK = 17;
/*    */   
/*    */   private static final int UPGRADE_PLUS_BLOCK = 5;
/*    */   private static final int DRAW = 1;
/*    */   
/*    */   public RorschachInDanmaku() {
/* 33 */     super(ID, IMG, 2, TYPE, COLOR, RARITY, TARGET);
/* 34 */     this.baseBlock = 17;
/* 35 */     this.magicNumber = this.baseMagicNumber = 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 40 */     KoishiMod.runAnimation("spellA");
/* 41 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));
/* 42 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new DrawCardNextTurnPower((AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getTitleFontSize() {
/* 48 */     return 16.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 54 */     if (!this.upgraded) {
/* 55 */       upgradeName();
/* 56 */       upgradeBlock(5);
/* 57 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Uncommon/RorschachInDanmaku.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */